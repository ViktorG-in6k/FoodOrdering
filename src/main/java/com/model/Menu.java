package com.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "menu")
public class Menu extends com.model.base.Entity {
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
    private Restaurant restaurant;

    public Menu(String name, String description, String URLimage, BigDecimal price){
        this.name=name;
        this.description = description;
        this.imageURL=URLimage;
        this.price = price;
    }

    public Menu(){
    }

    public Menu(Restaurant restaurant, String name, BigDecimal price){
        this.restaurant=restaurant;
        this.name=name;
        this.price=price;
    }

    public Menu(Restaurant restaurant, String name,String description, BigDecimal price){
        this.restaurant=restaurant;
        this.description=description;
        this.name=name;
        this.price=price;
    }

    public Menu(Restaurant restaurant, String name,String description,String imageURL, BigDecimal price){
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
}
