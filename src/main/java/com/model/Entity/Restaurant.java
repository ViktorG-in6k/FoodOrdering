package com.model.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "restaurant")
public class Restaurant extends com.model.base.Entity {
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String link;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private List<Item> item;

    public Restaurant(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Restaurant(String name, String phone, String link) {
        this(name, phone);
        this.link = link;
    }

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String description) {
        this.phone = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String imageURL) {
        this.link = imageURL;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}

