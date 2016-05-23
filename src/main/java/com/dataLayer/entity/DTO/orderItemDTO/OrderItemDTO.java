package com.dataLayer.entity.DTO.orderItemDTO;

import com.dataLayer.entity.DTO.userDTO.UserDTO;
import com.dataLayer.entity.DTO.itemDTO.ItemDTO;
import com.dataLayer.entity.base.OrderItem;
import java.math.BigDecimal;

public class OrderItemDTO {
    private ItemDTO item;
    private UserDTO user;
    private int itemAmount;
    private BigDecimal amountDiscount;
    private BigDecimal percentageDiscount;

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

    public BigDecimal getAmountDiscount() {
        return amountDiscount;
    }

    public void setAmountDiscount(BigDecimal amountDiscount) {
        this.amountDiscount = amountDiscount;
    }

    public BigDecimal getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(BigDecimal percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemDTO)) return false;
        return item.getId() == ((OrderItemDTO) o).getItem().getId();
    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }
}


