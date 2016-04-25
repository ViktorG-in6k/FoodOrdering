package com.splitBill.splitBillDTO.product;

public class ProductResponseJSON {
    private int status;
    private String message;
    private ProductDataResponse data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ProductDataResponse getData() {
        return data;
    }

    public void setData(ProductDataResponse data) {
        this.data = data;
    }
}
