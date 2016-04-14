package com.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "user")
public class User extends com.model.base.Entity {
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "event_list",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")})
    private Set<Event> eventsList = new HashSet<>();

    public User() {
    }

    public User(String email, String password, boolean enabled) {
        this.email = email;
        this.password = "aaa";
        this.enabled = enabled;
    }

    public User(String email, String password, boolean enabled, Set<UserRole> userRole) {
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

    public Set<Event> getEventsList() {
        return eventsList;
    }

    public void setEventsList(Set<Event> eventsList) {
        this.eventsList = eventsList;
    }
}
