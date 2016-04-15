package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity(name = "menu")
public class Item extends com.model.base.Entity {
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String imageURL;
    @Column
    private BigDecimal price;
    @OneToOne
    private Restaurant restaurant;

    public Item() {
    }

    public Item(String name, String description, String imageURL, BigDecimal price, Restaurant restaurant) {
        this.restaurant = restaurant;
        this.description = description;
        this.imageURL = imageURL;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
