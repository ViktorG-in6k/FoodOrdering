package com.DTOLayer.DTOEntity;

import java.time.LocalDateTime;

public class RequestEventDTO {
    private String name;
    private String description;
    private String imageURL;
    private LocalDateTime date;

    public RequestEventDTO(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
    }

    public RequestEventDTO() {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

