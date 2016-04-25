package com.splitBill.splitBillDTO;

public class EventBillDTO {
    private int id;
    private UserDTO creator;

    public EventBillDTO() {
    }

    public EventBillDTO(int id, UserDTO creator) {
        this.id = id;
        this.creator = creator;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
