package com.DTOLayer.DTOEntity.itemDTO;

import com.model.Entity.Item;

import java.math.BigDecimal;

public class ItemDTO {
    private int id;
    private String name;
    private BigDecimal price;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
    }

    public ItemDTO(int id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}

