package com.serviceLayer.implementation;

import com.dataLayer.entity.DTO.itemDTO.ItemDTO;
import com.dataLayer.entity.DTO.RequestItemDTO;
import com.dataLayer.entity.DTO.itemDTO.ItemRequest;
import com.dataLayer.DAO.Interfaces.ItemDAO;
import com.dataLayer.entity.DTO.orderItemDTO.OrderItemDTO;
import com.dataLayer.entity.DTO.userDTO.UserDTO;
import com.dataLayer.entity.base.Item;
import com.dataLayer.entity.base.Order;
import com.dataLayer.entity.base.OrderItem;
import com.dataLayer.entity.base.User;
import com.serviceLayer.service.ItemService;
import com.serviceLayer.service.OrderItemService;
import com.serviceLayer.service.OrderService;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemDAO itemDAO;
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;

    @Override
    public void save(Item item) {
        itemDAO.save(item);
    }

    @Override
    public void saveByRequest(ItemRequest itemRequest) {
        Item item = new Item(itemRequest.getName(), itemRequest.getPrice(), restaurantService.getRestaurantById(itemRequest.getRestaurantId()));
        itemDAO.save(item);
    }

    @Override
    public Item getItemById(int id) {
        return itemDAO.getItemById(id);
    }

    @Override
    public ItemDTO getItemDTOById(int id) {
        return new ItemDTO(itemDAO.getItemById(id));
    }

    @Override
    public void updateItemPrice(int id, double price) {
        itemDAO.updatePrice(id,new BigDecimal(price));
    }

    @Override
    public Set<ItemDTO> getUnusedItems(int orderId, String name){
        Order order = orderService.getOrderById(orderId);
        List<Item> items = itemDAO.getItemsByRestaurantIdAndName(order.getRestaurant().getId(), name);
        List<OrderItem> orderItems = orderItemService.getOrderListByOrderId(orderId);
        Set<ItemDTO> itemDTOs = new HashSet<>();
        for (Item item : items) {
            boolean isEqual = false;
            for (OrderItem orderItem : orderItems) {
                if (item.getId() == orderItem.getItem().getId()) {
                    isEqual = true;
                    break;
                }
            }
            if(!isEqual){
                itemDTOs.add(new ItemDTO(item));
            }
        }
        return itemDTOs;
    }

    @Override
    public void updateItemName(int id, String title) {
        itemDAO.updateName(id,title);
    }
}

