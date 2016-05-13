package com.dataLayer.entity.base;

import javax.persistence.*;

@javax.persistence.Entity(name = "order_item")
public class OrderItem extends com.dataLayer.entity.base.Entity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "item_amount", nullable = false)
    private int itemAmount;

    @OneToOne
    private Order order;

    public OrderItem() {
    }

    public OrderItem(User user, Item item, Order order) {
        this.user = user;
        this.item = item;
        this.order = order;
        this.itemAmount = 1;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

