package com.dataLayer.splitBillDTO.product;

import java.math.BigDecimal;

public class ProductRequestJSON {
    private int amount;
    private String title;
    private BigDecimal price;

    public ProductRequestJSON(int amount, String title, BigDecimal price) {
        this.amount = amount;
        this.title = title;
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
}
