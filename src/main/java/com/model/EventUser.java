package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "event_list")
public class EventUser extends com.model.base.Entity{

    @Column
    private  int user_id;

    @Column
    private  int event_id;

    public EventUser(){
    }

    public EventUser(int user_id,int event_id){
        this.user_id=user_id;
        this.event_id=event_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getItem_id() {
        return user_id;
    }

    public void setItem_id(int item_id) {
        this.user_id = item_id;
    }
}
