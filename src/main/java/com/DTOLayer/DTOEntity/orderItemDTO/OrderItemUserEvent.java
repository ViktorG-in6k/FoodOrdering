package com.DTOLayer.DTOEntity.orderItemDTO;

import com.DTOLayer.DTOEntity.eventDTO.EventDTO;
import com.DTOLayer.DTOEntity.itemDTO.ItemDTO;
import com.DTOLayer.DTOEntity.orderDTO.OrderDTO;
import com.DTOLayer.DTOEntity.userDTO.UserDTO;

public class OrderItemUserEvent {
    private ItemDTO item;
    private UserDTO user;
    private int itemAmount;
    private OrderDTO order;
    private EventDTO event;

    public OrderItemUserEvent(ItemDTO item) {
    }

    public OrderItemUserEvent(ItemDTO item, UserDTO user, int itemAmount, OrderDTO order, EventDTO event) {
        this.item = item;
        this.user = user;
        this.itemAmount = itemAmount;
        this.order = order;
        this.event = event;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }
}
