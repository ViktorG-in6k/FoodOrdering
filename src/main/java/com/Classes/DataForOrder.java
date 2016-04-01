package com.Classes;


import com.model.Menu;

import java.math.BigDecimal;

public class DataForOrder {

    private Menu item;
    private int count;
    private BigDecimal cost;

    public Menu getItem() {
        return item;
    }

    public void setItem(Menu item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DataForOrder(Menu item,  int count){
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
