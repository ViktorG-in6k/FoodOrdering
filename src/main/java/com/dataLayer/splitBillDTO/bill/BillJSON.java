package com.dataLayer.splitBillDTO.bill;

public class BillJSON {
    private int id;
    private String name;
    private EventBillJSON event;
    private UserResponce user;

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

    public EventBillJSON getEvent() {
        return event;
    }

    public void setEvent(EventBillJSON event) {
        this.event = event;
    }

    public UserResponce getUser() {
        return user;
    }

    public void setUser(UserResponce user) {
        this.user = user;
    }
}

