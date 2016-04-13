package com.serviceLayer.implementation;

import com.dataLayer.DAO.EventUserDAO;
import com.model.Event;
import com.model.EventResponse;
import com.model.EventUser;
import com.model.User;
import com.serviceLayer.service.EventUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class EventUserServiceImpl implements EventUserService {
    @Autowired
    EventUserDAO eventUserDAO;

    public void save(EventUser eventUser) {
        eventUserDAO.save(eventUser);
    }

    public Set<EventResponse> getAllEvents(User user) {
        Set<EventResponse> result = new HashSet<>();
        for (Event event : user.getEventsList()) {
            result.add(new EventResponse(event));
        }
        return result;
    }

    public EventUser getEventUserById(int user_id, int event_id) {
        return eventUserDAO.getEventUserById(user_id, event_id);
    }
}
