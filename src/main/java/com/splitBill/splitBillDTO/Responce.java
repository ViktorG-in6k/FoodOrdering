package com.splitBill.splitBillDTO;

public class Responce {
    private int status;
    private String message;
    private BillDTO data;

    public Responce() {
    }

    public Responce(int status, String message, BillDTO data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public BillDTO getData() {
        return data;
    }

    public void setData(BillDTO data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
