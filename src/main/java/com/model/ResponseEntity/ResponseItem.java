package com.model.ResponseEntity;

import com.model.Item;

import java.math.BigDecimal;

public class ResponseItem {
    private int id;
    private String name;
    private String description;
    private String imageURL;
    private BigDecimal price;
    private ResponseRestaurant responseRestaurant;

    public ResponseItem(Item item){
        this.id = item.getId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.imageURL = item.getImageURL();
        this.responseRestaurant = new ResponseRestaurant(item.getRestaurant());
        this.price = item.getPrice();
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



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
