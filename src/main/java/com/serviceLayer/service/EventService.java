package com.serviceLayer.service;

import com.dataLayer.entity.DTO.eventDTO.RequestEventDTO;
import com.dataLayer.entity.Event;

import java.util.Set;


public interface EventService {
    public void save(RequestEventDTO e);

    void save(RequestEventDTO eventDTO, int userId);

    public Event getEventById(int id);

    public Set<Event> getListOfAllEvents();

    public void update(Event event);
}

