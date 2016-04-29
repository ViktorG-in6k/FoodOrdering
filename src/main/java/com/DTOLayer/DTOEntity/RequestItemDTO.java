package com.DTOLayer.DTOEntity;

import java.math.BigDecimal;

public class RequestItemDTO {
    private int id;
    private BigDecimal price;
    private int eventId;
    private String name;

    public RequestItemDTO() {
    }

    public RequestItemDTO(int id, BigDecimal price, int eventId) {
        this.id = id;
        this.price = price;
        this.eventId = eventId;
        this.name = null;
    }

    public RequestItemDTO(int id, String name, int eventId) {
        this.id = id;
        this.name = name;
        this.eventId = eventId;
        this.price = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

