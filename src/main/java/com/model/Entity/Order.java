package com.model.Entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "order_info")
public class Order extends com.model.base.Entity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payer_id", nullable = false)
    private User payer;

    @OneToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @OneToMany(fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    public Order(Restaurant restaurant, Event event, Status status) {
        this.restaurant = restaurant;
        this.event = event;
        this.status = status;
    }

    public Order() {
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}

