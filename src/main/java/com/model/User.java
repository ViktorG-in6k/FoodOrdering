package com.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "user")
public class User extends com.model.base.Entity{
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRole> userRole = new HashSet<UserRole>(0);

    public User() {
    }

    public User(String email, String password, boolean enabled) {
        this.email = email;
        this.password = "aaa";
        this.enabled = enabled;
    }

    public User(String email, String password,  boolean enabled, Set<UserRole> userRole) {
        this.email = email;
        this.password = "aaa";
        this.enabled = enabled;
        this.userRole = userRole;
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

    public Set<UserRole> getUserRole() {
        return this.userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }
}
