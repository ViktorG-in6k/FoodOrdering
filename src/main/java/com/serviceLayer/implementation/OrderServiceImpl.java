package com.serviceLayer.implementation;

import com.dataLayer.DAO.Interfaces.OrderDAO;
import com.dataLayer.entity.DTO.orderDTO.OrderPlacementStatus;
import com.dataLayer.entity.DTO.orderItemDTO.OrderItemDTO;
import com.dataLayer.entity.DTO.orderItemDTO.OrderItemRequest;
import com.dataLayer.entity.base.*;
import com.dataLayer.entity.external.SplitBillApi;
import com.dataLayer.splitBillDTO.product.ProductRequestJSON;
import com.serviceLayer.googleAuthentication.CurrentUserDetails;
import com.serviceLayer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    UserService userService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    EventService eventService;
    @Autowired
    ItemService itemService;
    @Autowired
    RestaurantService restaurantService;

    @Override
    public void save(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    public void save(OrderItemRequest itemRequest) {
        orderDAO.saveOrder(new Order());
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderDAO.getOrderByOrderId(orderId);
    }

    @Override
    public List<Order> getOrdersByEventIdAndRestaurantId(int eventId, int restaurantId) {
        return orderDAO.getOrdersByEventIdAndRestaurantId(eventId, restaurantId);
    }

    @Override
    public List<Order> getOrdersByEventIdAndRestaurantIdAndStatus(int eventId, int restaurantId, Status status) {
        return orderDAO.getOrderByEventIdAndRestaurantIdAndStatus(eventId, restaurantId, status);
    }

    @Override
    public void setPayerById(int orderId, int payerId) {
        orderDAO.setPayer(orderId, payerId);
    }

    @Override
    public void removePayer(int orderId) {
        orderDAO.removePayer(orderId);
    }

    @Transactional
    @Override
    public OrderPlacementStatus getOrderPlacementStatus(Order order, Authentication authentication) {
        Set<User> participants = new HashSet<>();
        if (order != null) {
            List<OrderItemDTO> orderItems = orderItemService.getOrderItemListDTOByOrderId(order.getId());

            fillingParticipantsList(participants, orderItems);

            int participantsAmount = participants.size();
            return new OrderPlacementStatus(order, participantsAmount, isMineOrder(order, authentication));
        }

        return null;
    }

    @Override
    public OrderPlacementStatus getOrderPlacementStatusByOrderId(Order order, Authentication authentication) {
        Set<User> participants = new HashSet<>();

        List<OrderItemDTO> orderItems = orderItemService.getOrderItemListDTOByOrderId(order.getId());

        fillingParticipantsList(participants, orderItems);

        int participantsAmount = participants.size();
        return new OrderPlacementStatus(order, participantsAmount, isMineOrder(order, authentication));
    }

    private void fillingParticipantsList(Set<User> participants, List<OrderItemDTO> orderItems) {
        for (OrderItemDTO itemDTO : orderItems) {
            participants.add(userService.getUser(itemDTO.getUser().getId()));
        }
    }

    @Override
    public boolean isMineOrder(Order order, Authentication authentication) {
        int currentUserId = ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId();

        for (OrderItem item : order.getOrderItems()) {
            if (isSameUsers(currentUserId, item)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameUsers(int currentUserId, OrderItem item) {
        return item.getUser().getId() == currentUserId;
    }

    @Override
    public void changeOrderStatus(int orderId, Status status, int splitBillId) throws IOException {
        orderDAO.changeOrderStatus(orderId, status);
        if (status.equals(Status.SPLIT_BILL)) {
            sendOrderToSplitBill(orderId, splitBillId);
        }
    }

    @Override
    public Order createOrder(int eventId, int restaurantId) {
        Event event = eventService.getEventById(eventId);
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        Order order = new Order(restaurant, event, Status.PENDING);
        save(order);
        return order;
    }

    @Override
    public void sendOrderToSplitBill(int orderId, int splitBillId) throws IOException {
        SplitBillApi splitBillApi = new SplitBillApi();
        Order order = getOrderById(orderId);

        List<OrderItemDTO> orders = orderItemService.getOrderItemListDTOByOrderId(orderId);
        List<OrderItemDTO> commonOrders = fillingCommonOrders(orders);

        BigDecimal discount = getDiscount(order, commonOrders);

        createNewBillInSplitBill(orderId, splitBillId, splitBillApi, order);
        fillingBillOnSplitBill(splitBillApi, commonOrders, discount);
    }

    private void fillingBillOnSplitBill(SplitBillApi splitBillApi, List<OrderItemDTO> commonOrders, BigDecimal discount) throws IOException {
        for (OrderItemDTO orderItem : commonOrders) {
            BigDecimal priceWithDiscount = orderItem.getItem().getPrice();
            if (discount.doubleValue() > 0) {
                priceWithDiscount = priceWithDiscount.multiply(discount).divide(new BigDecimal(100));
            }
            ProductRequestJSON productRequestJSON = getProductRequestJSON(orderItem, priceWithDiscount);
            splitBillApi.newProduct(productRequestJSON);
        }
    }

    private void createNewBillInSplitBill(int orderId, int splitBillId, SplitBillApi splitBillApi, Order order) throws IOException {
        splitBillApi.login(order.getPayer().getEmail());

        splitBillApi.newBill(splitBillId);
        orderDAO.setSplitBillId(orderId, splitBillApi.getBillId());
    }

    private List<OrderItemDTO> fillingCommonOrders(List<OrderItemDTO> orders) {
        List<OrderItemDTO> commonOrders = new ArrayList<>();

        for (OrderItemDTO orderItemDTO : orders) {
            if (commonOrders.contains(orderItemDTO)) {
                setAmountOfEachItemInCommonOrders(commonOrders, orderItemDTO);
            } else {
                commonOrders.add(orderItemDTO);
            }
        }

        return commonOrders;
    }

    private void setAmountOfEachItemInCommonOrders(List<OrderItemDTO> commonOrders, OrderItemDTO orderItemDTO) {
        for (OrderItemDTO orderItem : commonOrders) {
            if (isSameOrderItems(orderItemDTO, orderItem)) {
                orderItem.setItemAmount(orderItem.getItemAmount() + orderItemDTO.getItemAmount());
            }
        }
    }

    private boolean isSameOrderItems(OrderItemDTO orderItemDTO, OrderItemDTO orderItem) {
        return orderItem.getItem().getId() == orderItemDTO.getItem().getId();
    }

    private ProductRequestJSON getProductRequestJSON(OrderItemDTO orderItem, BigDecimal priceWithDiscount) {
        return new ProductRequestJSON(
                orderItem.getItemAmount(),
                orderItem.getItem().getName(),
                orderItem.getItem().getPrice().subtract(priceWithDiscount)
        );
    }


    private BigDecimal getDiscount(Order order, List<OrderItemDTO> commonOrders) {
        if (isDiscountEquallNull(order)) {
            return new BigDecimal(0);
        }

        BigDecimal total = getTotal(commonOrders);
        BigDecimal percentageDiscountFromAmountDiscount = calculateThePercentageDiscount(order, total);

        if (order.getPercentageDiscount() != null) {
            if (percentageDiscountFromAmountDiscount != null) {
                return percentageDiscountFromAmountDiscount.add(order.getPercentageDiscount());
            } else {
                return order.getPercentageDiscount();
            }
        }
        return percentageDiscountFromAmountDiscount;

    }

    private boolean isDiscountEquallNull(Order order) {
        return order.getAmountDiscount() == null && order.getPercentageDiscount() == null;
    }

    private BigDecimal calculateThePercentageDiscount(Order order, BigDecimal total) {
        if (order.getAmountDiscount() != null) {
            return order.getAmountDiscount().multiply(new BigDecimal(100)).divide(total);
        } else {
            return null;
        }
    }

    @Override
    public List<OrderPlacementStatus> getOrderPlacementStatusByEventIdAndRestaurantId(int eventId, int restaurantId, Authentication authentication) {
        List<Order> orders = orderDAO.getOrdersByEventIdAndRestaurantId(eventId, restaurantId);
        return orders.stream().map(order -> getOrderPlacementStatus(order, authentication)).collect(Collectors.toList());
    }

    @Override
    public void updatePercentageDiscount(int orderId, double percentageDiscount) {
        Order order = orderDAO.getOrderByOrderId(orderId);
        order.setPercentageDiscount(new BigDecimal(percentageDiscount));
        orderDAO.updateOrder(order);
    }

    @Override
    public void updateAmountDiscount(int orderId, double amount) {
        Order order = orderDAO.getOrderByOrderId(orderId);
        order.setAmountDiscount(new BigDecimal(amount));
        orderDAO.updateOrder(order);
    }

    public BigDecimal getTotal(List<OrderItemDTO> commonOrders) {
        BigDecimal total = new BigDecimal(0);
        for (OrderItemDTO orderItem : commonOrders) {
            total = total.add(orderItem.getItem().getPrice().multiply(new BigDecimal(orderItem.getItemAmount())));
        }

        return total;
    }
}
