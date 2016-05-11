package com.DTOLayer.DTOEntity.orderItemDTO;

import com.DTOLayer.DTOEntity.itemDTO.ItemDTO;
import com.DTOLayer.DTOEntity.orderDTO.OrderDTO;
import com.DTOLayer.DTOEntity.userDTO.UserDTO;
import com.model.Entity.OrderItem;

public class OrderItemDTO {
    private ItemDTO item;
    private UserDTO user;
    private int itemAmount;
    private OrderDTO order;

    public OrderItemDTO() {
    }

    public OrderItemDTO(OrderItem orderItem){
        this.item = new ItemDTO(orderItem.getItem());
        this.user = new UserDTO(orderItem.getUser());
        this.itemAmount = orderItem.getItemAmount();
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
}

