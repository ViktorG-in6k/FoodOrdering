package com.model.Entity;

import javax.persistence.*;

@Entity(name = "order_list")
public class Order extends com.model.base.Entity {

    public Order() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "responsibility_user_id")
    private User responsibilityUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "item_amount", nullable = false)
    private int itemAmount;

    public Order(User user, Item item, Event event) {
        this.user = user;
        this.item = item;
        this.event = event;
        this.restaurant = item.getRestaurant();
        this.itemAmount = 1;
    }

    public Order(User user, Item item, Event event, int itemAmount) {
        this.user = user;
        this.item = item;
        this.event = event;
        this.restaurant = item.getRestaurant();
        this.itemAmount = itemAmount;
    }

    public User getResponsibilityUser() {
        return responsibilityUser;
    }

    public void setResponsibilityUser(User responsibilityUser) {
        this.responsibilityUser = responsibilityUser;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }
}

