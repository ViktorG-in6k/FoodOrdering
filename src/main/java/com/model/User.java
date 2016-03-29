package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "user")
public class User extends com.model.base.Entity {

    @Column
    private String name;

    @Column
    private String email;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
