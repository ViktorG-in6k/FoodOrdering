package com.DTOLayer.DTOEntity.orderDTO;

import com.DTOLayer.DTOEntity.eventDTO.EventDTO;
import com.DTOLayer.DTOEntity.restaurantDTO.RestaurantDTO;
import com.DTOLayer.DTOEntity.userDTO.UserDTO;
import com.model.Entity.Order;

public class OrderDTO {
    private int id;
    private RestaurantDTO restaurant;
    private EventDTO event;
    private String status;
    private UserDTO payer;

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
}

