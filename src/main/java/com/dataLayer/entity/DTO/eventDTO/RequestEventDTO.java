package com.dataLayer.entity.DTO.eventDTO;

import java.time.LocalDateTime;

public class RequestEventDTO {
    private String name;
    private LocalDateTime date;

    public RequestEventDTO() {
    }

    public RequestEventDTO(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
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
}

