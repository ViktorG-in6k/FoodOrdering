package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    public Item(String name, String description, String URLimage, BigDecimal price){
        this.name=name;
        this.description = description;
        this.imageURL=URLimage;
        this.price = price;
    }

    public Item(){
    }

    public Item(Restaurant restaurant, String name, String description, String imageURL, BigDecimal price){
        this.restaurant=restaurant;
        this.description=description;
        this.imageURL=imageURL;
        this.name=name;
        this.price=price;
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

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", price=" + price +
                ", restaurant=" + restaurant +
                '}';
    }
}
