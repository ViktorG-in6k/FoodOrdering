package com.splitBill.splitBillDTO.user;

public class UserLoginResponceJSON {
    private int status;
    private String message;
    private String data;

    public UserLoginResponceJSON(){}

    public UserLoginResponceJSON(int status, String message, String data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

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
