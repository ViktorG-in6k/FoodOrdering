package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "order_list")
public class Order extends com.model.base.Entity {
    @Column
    private int item_id;
    @Column
    private int event_id;

    public Order() {
    }

    public Order(int item_id, int event_id) {
        this.item_id = item_id;
        this.event_id = event_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}
