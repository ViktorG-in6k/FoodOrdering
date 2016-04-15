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

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public ResponseRestaurant getResponseRestaurant() {
        return responseRestaurant;
    }
}
