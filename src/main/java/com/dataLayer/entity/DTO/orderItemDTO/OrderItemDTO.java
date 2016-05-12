package com.dataLayer.entity.DTO.orderItemDTO;

import com.dataLayer.entity.DTO.userDTO.UserDTO;
import com.dataLayer.entity.DTO.itemDTO.ItemDTO;
import com.dataLayer.entity.OrderItem;

public class OrderItemDTO {
    private ItemDTO item;
    private UserDTO user;
    private int itemAmount;

    public OrderItemDTO() {
    }

    public OrderItemDTO(OrderItem orderItem) {
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
}

