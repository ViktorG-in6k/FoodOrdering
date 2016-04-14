package com.dataLayer.DAO;


import com.model.EventUser;

public interface EventUserDAO {
    public void save(EventUser eventUser);

    EventUser getEventUserById(int user_id, int event_id);
}