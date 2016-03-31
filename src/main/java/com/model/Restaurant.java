package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity(name = "restaurant")
public class Restaurant extends com.model.base.Entity {


    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String imageURL;

    public Restaurant(String name, LocalDateTime date) {
        this.name = name;
    }

    public Restaurant(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Restaurant(String name, String description, String imageURL) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;

    }

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private List<Menu> menu;

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public void addToMenu(Menu item) {
        this.menu.add(item);
    }
}