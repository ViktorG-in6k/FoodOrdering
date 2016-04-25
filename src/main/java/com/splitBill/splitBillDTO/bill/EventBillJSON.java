package com.splitBill.splitBillDTO.bill;

import com.splitBill.splitBillDTO.user.UserResponce;

public class EventBillJSON {
    private int id;
    private UserResponce creator;

    public EventBillJSON() {
    }

    public EventBillJSON(int id, UserResponce creator) {
        this.id = id;
        this.creator = creator;
    }

    public UserResponce getCreator() {
        return creator;
    }

    public void setCreator(UserResponce creator) {
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
