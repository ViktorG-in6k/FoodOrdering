package com.DTOLayer.JSON;

import com.model.Entity.Item;

import java.math.BigDecimal;

public class ItemJson {
    private int id;
    private String name;
    private String description;

    private BigDecimal price;
    private int count;

    public ItemJson(Item item){
        id = item.getId();
        name = item.getName();
        description = item.getDescription();
        price = item.getPrice();
        count = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
