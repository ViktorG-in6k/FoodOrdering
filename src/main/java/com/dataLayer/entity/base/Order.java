package com.dataLayer.entity.base;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity(name = "order_info")
public class Order extends com.dataLayer.entity.base.Entity {
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
    @ManyToOne
    @JoinColumn(name = "payer_id")
    private User payer;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @Column (name = "bill_id")
    private Integer billId;
    @OneToMany(fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    public Order(Restaurant restaurant, Event event, Status status) {
        this.restaurant = restaurant;
        this.event = event;
        this.status = status;
    }

    public Order(Restaurant restaurant, Event event, Status status, int billId) {
        this(restaurant, event, status);
        this.billId = billId;
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

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }
}

