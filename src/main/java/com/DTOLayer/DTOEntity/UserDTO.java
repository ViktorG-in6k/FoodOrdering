package com.DTOLayer.DTOEntity;

import com.model.Entity.User;

public class UserDTO {
    protected int id;
    protected String email;

    public UserDTO(User user) {
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

