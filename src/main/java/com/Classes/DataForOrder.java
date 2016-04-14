package com.Classes;

import com.model.Item;

import java.math.BigDecimal;

public class DataForOrder {
    private Item item;
    private int count;
    private BigDecimal cost;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DataForOrder(Item item, int count){
        this.item = item;
        this.count = count;
        cost = item.getPrice();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
