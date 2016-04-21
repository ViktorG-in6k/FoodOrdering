package com.DTOLayer.DTOEntity;

import com.model.Entity.Item;

import java.math.BigDecimal;

public class ItemDTO {
    private int id;
    private String name;
    private String description;
    private String imageURL;
    private BigDecimal price;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.imageURL = item.getImageURL();
        this.price = item.getPrice();
    }

    public ItemDTO(int id, BigDecimal price) {
        this.id = id;
        this.price = price;
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
}

