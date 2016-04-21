package com.DTOLayer.DTOEntity;

import com.model.Entity.Item;

import java.math.BigDecimal;

public class ItemDTO {
    private int id;
    private String name;
    private String description;
    private String imageURL;
    private BigDecimal price;

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

