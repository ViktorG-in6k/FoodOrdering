package com.dataLayer.entity.DTO.orderDTO;

import com.dataLayer.entity.DTO.userDTO.UserDTO;
import com.dataLayer.entity.Order;

public class OrderPlacementStatus {
    private UserDTO payer;
    private int participantsAmount;
    private int restaurantId;
    private boolean isMineOrder;
    private OrderDTO order;

    public OrderPlacementStatus(Order order, int participantsAmount, boolean isMineOrder) {
        if (order.getPayer() != null) {
            this.payer = new UserDTO(order.getPayer());
        }
        this.participantsAmount = participantsAmount;
        this.restaurantId = order.getRestaurant().getId();
        this.isMineOrder = isMineOrder;
        this.order = new OrderDTO(order);
    }

    public UserDTO getPayer() {
        return payer;
    }

    public void setPayer(UserDTO payer) {
        this.payer = payer;
    }

    public int getParticipantsAmount() {
        return participantsAmount;
    }

    public void setParticipantsAmount(int participantsAmount) {
        this.participantsAmount = participantsAmount;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public boolean isMineOrder() {
        return isMineOrder;
    }

    public void setMineOrder(boolean mineOrder) {
        isMineOrder = mineOrder;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }
}

