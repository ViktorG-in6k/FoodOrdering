package com.model.ResponseEntity;

import com.model.Event;
import com.model.Item;
import com.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ResponseEvent {
    private int id;
    private String name;

    private String description;

    private String imageURL;

    private LocalDateTime date;

    private User user;

    private List<ResponseItem> itemsList;

    public ResponseEvent(String name, String description, String imageURL, LocalDateTime date) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.date = date;
    }

    public ResponseEvent(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.imageURL = event.getImageURL();
        this.date = event.getDate();
        this.user = event.getUser();

        this.itemsList = new ArrayList<>();
        for (Item itemOfEvent: event.getItemsList()) {
            this.itemsList.add(new ResponseItem(itemOfEvent));
        }
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

//    public List<ResponseItem> getItemsList() {
//        return itemsList;
//    }
//
//    public void setItemsList(List<ResponseItem> itemsList) {
//        this.itemsList = itemsList;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
