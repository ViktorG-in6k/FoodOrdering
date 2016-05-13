package com.splitBill.splitBillDTO.product;

import java.math.BigDecimal;

public class ProductDataResponse {
    private int id;
    private String title;
    private BigDecimal price;
    private int amount;
    private Object bill;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public Object getBill() {
        return bill;
    }

    public void setBill(Object bill) {
        this.bill = bill;
    }
}
