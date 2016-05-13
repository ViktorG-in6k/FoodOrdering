package com.DTOLayer.DTOEntity.orderDTO;

import com.DTOLayer.DTOEntity.orderItemDTO.OrderItemDTO;
import com.model.Entity.Order;
import com.model.Entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderListDTO {
    private OrderDTO order;
    private List<OrderItemDTO> items;

    public OrderListDTO(){}

    public OrderListDTO(Order order, List<OrderItem> items){
        this.order = new OrderDTO(order);
        this.items = new ArrayList<>();
        items.forEach(item -> this.items.add(new OrderItemDTO(item)));
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
