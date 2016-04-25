package com.splitBill.splitBillDTO;

public class BillDTO {
    private int id;
    private String name;
    private EventBillDTO event;
    private UserDTO user;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventBillDTO getEvent() {
        return event;
    }

    public void setEvent(EventBillDTO event) {
        this.event = event;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
