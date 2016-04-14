package com.model;

import javax.persistence.*;

@Entity(name = "user")
public class User extends com.model.base.Entity {
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    public User() {
    }

    public User(String email, String password, boolean enabled) {
        this.email = email;
        this.password = "aaa";
        this.enabled = enabled;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
