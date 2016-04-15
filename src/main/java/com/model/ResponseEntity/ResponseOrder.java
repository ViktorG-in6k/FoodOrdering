package com.model.ResponseEntity;

import com.model.Order;

public class ResponseOrder {
    private ResponseItem item;
    private ResponseUser user;
    private ResponseEvent event;

    public ResponseOrder(Order order){
        this.item = new ResponseItem(order.getItem());
        this.user = new ResponseUser(order.getUser());
        this.event = new ResponseEvent(order.getEvent());
    }

    public ResponseItem getItem() {
        return item;
    }

    public ResponseUser getUser() {
        return user;
    }

    public ResponseEvent getEvent() {
        return event;
    }
}
