package com.DTOLayer.DTOEntity;

import com.model.Entity.Order;

public class OrderDTO {
    protected ItemDTO item;

    protected UserDTO user;

    protected EventDTO event;

    public OrderDTO(Order order){
        this.item = new ItemDTO(order.getItem());
        this.user = new UserDTO(order.getUser());
        this.event = new EventDTO(order.getEvent());
    }

    public ItemDTO getItem() {
        return item;
    }

    public UserDTO getUser() {
        return user;
    }

    public EventDTO getEvent() {
        return event;
    }
}
