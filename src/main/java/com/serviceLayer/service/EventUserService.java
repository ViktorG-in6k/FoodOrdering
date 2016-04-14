package com.serviceLayer.service;


import com.model.EventUser;
import com.model.ResponseEntity.ResponseEvent;
import com.model.User;

import java.util.Set;

public interface EventUserService {
    public void save(EventUser eventUser);

    public Set<ResponseEvent> getAllEvents(User user);

    public EventUser getEventUserById(int user_id, int event_id);
}