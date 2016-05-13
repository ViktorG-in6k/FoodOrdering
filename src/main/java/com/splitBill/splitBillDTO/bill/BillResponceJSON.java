package com.splitBill.splitBillDTO.bill;

public class BillResponceJSON {
    private int status;
    private String message;
    private BillJSON data;

    public BillResponceJSON() {
    }

    public BillResponceJSON(int status, String message, BillJSON data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public BillJSON getData() {
        return data;
    }

    public void setData(BillJSON data) {
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

