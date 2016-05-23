package com.dataLayer.entity.DTO.orderDTO;

import com.dataLayer.entity.DTO.eventDTO.EventDTO;
import com.dataLayer.entity.DTO.restaurantDTO.RestaurantDTO;
import com.dataLayer.entity.DTO.userDTO.UserDTO;
import com.dataLayer.entity.base.Order;
import javax.persistence.Column;
import java.math.BigDecimal;

public class OrderDTO {
    private int id;
    private RestaurantDTO restaurant;
    private EventDTO event;
    private String status;
    private UserDTO payer;
    private BigDecimal amountDiscount;
    private BigDecimal percentageDiscount;

    public OrderDTO() {
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.restaurant = new RestaurantDTO(order.getRestaurant());
        this.event = new EventDTO(order.getEvent());
        this.status = order.getStatus().toString();
        if (order.getPayer() != null) {
            this.payer = new UserDTO(order.getPayer());
        }
        this.percentageDiscount = order.getPercentageDiscount();
        this.amountDiscount = order.getAmountDiscount();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RestaurantDTO getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantDTO restaurant) {
        this.restaurant = restaurant;
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserDTO getPayer() {
        return payer;
    }

    public void setPayer(UserDTO payer) {
        this.payer = payer;
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
}

