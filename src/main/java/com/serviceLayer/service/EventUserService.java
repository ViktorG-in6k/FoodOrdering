package com.serviceLayer.service;


import com.model.EventResponse;
import com.model.EventUser;
import com.model.User;

import java.util.Set;

public interface EventUserService {
    public void save(EventUser eventUser);

     public Set<EventResponse> getAllEvents(User user);

    public EventUser getEventUserById(int user_id, int event_id);
}