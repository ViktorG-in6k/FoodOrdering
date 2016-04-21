package com.DTOLayer.DTOEntity;

import java.math.BigDecimal;

public class RequestItemDTO {
    private int id;
    private BigDecimal price;
    private int eventId;

    public RequestItemDTO(){}

    public RequestItemDTO(int id, BigDecimal price,int eventId){
        this.id = id;
        this.price = price;
        this.eventId = eventId;
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
}
