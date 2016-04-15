package com.model.ResponseEntity;

import com.model.User;

public class ResponseUser {
    private int id;
    private String email;

    public ResponseUser(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
