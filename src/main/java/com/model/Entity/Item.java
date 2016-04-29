package com.model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity(name = "menu")
public class Item extends com.model.base.Entity {
    @Column
    private String name;
    @Column
    private BigDecimal price;
    @OneToOne
    private Restaurant restaurant;

    public Item() {
    }

    public Item(String name, BigDecimal price, Restaurant restaurant) {
        this.restaurant = restaurant;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}

