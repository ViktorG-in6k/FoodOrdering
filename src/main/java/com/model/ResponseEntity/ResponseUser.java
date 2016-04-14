package com.model.ResponseEntity;

import com.model.Event;
import com.model.User;

import java.util.HashSet;
import java.util.Set;

public class ResponseUser {
    private int id;
    private String email;
    private Set<ResponseEvent> eventsList = new HashSet<>();

    public ResponseUser(String email) {
        this.email = email;
    }
    public ResponseUser(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.eventsList = new HashSet<ResponseEvent>();
        for (Event e: user.getEventsList()) {
            this.eventsList.add(new ResponseEvent(e));
        }
    }

    public Set<ResponseEvent> getEventsList() {
        return eventsList;
    }

    public void setEventsList(Set<ResponseEvent> eventsList) {
        this.eventsList = eventsList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
