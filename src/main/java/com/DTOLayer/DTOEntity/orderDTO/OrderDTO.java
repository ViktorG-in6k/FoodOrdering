package com.DTOLayer.DTOEntity.orderDTO;

import com.DTOLayer.DTOEntity.eventDTO.EventDTO;
import com.DTOLayer.DTOEntity.itemDTO.ItemDTO;
import com.DTOLayer.DTOEntity.userDTO.UserDTO;
import com.model.Entity.Order;

public class OrderDTO {
    private ItemDTO item;

    private UserDTO user;

    private EventDTO event;

    private boolean ordered;

    public OrderDTO(Order order) {
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

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }
}

