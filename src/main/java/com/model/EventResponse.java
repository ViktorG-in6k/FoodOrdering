package com.model;

import java.time.LocalDateTime;


public class EventResponse {

    private String name;
    private LocalDateTime date;

    public EventResponse(Event event){
        name = event.getName();
        date = event.getDate();
    }

}
