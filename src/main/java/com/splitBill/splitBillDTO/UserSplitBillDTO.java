package com.splitBill.splitBillDTO;

public class UserSplitBillDTO {
    private int status;
    private String message;
    private String data;

    public UserSplitBillDTO(){}

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
