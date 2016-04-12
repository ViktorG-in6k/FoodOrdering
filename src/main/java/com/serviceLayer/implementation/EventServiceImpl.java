package com.serviceLayer.implementation;


import com.dataLayer.DAO.EventDAO;
import com.model.Event;
import com.serviceLayer.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;



@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventDAO eventDAO;

    public void save(Event e) {

        if(e.getImageURL().equals("")) {
            if (e.getDate().getHour() >12 && e.getDate().getHour() < 16) {
                e.setImageURL("/resources/image/lanch.jpg");
            }
            else if(e.getDate().getHour() >16 || (e.getDate().getHour() > -1 && e.getDate().getHour() < 5)){
                e.setImageURL("/resources/image/food.jpg");
            }
            else{
                e.setImageURL("/resources/image/breakfast.jpg");
            }
        }
        eventDAO.save(e);
    }



    public Event getEventById(int id){
        return eventDAO.getEventById(id);
    }

    public Set<Event> getListOfAllEvents() {
        return eventDAO.getListOfAllEvents();
    }

    public List<Event> getListOfEvents(String eventName) {
        return eventDAO.getListOfEvents(eventName);
    }

    public List<Event> getListOfEventsByDate(LocalDate eventDate) {
        return eventDAO.getListOfEventsByDate(eventDate);
    }

    public List<Event> getListOfEventsByNameAndDate(String eventName, LocalDate eventDate) {
        return eventDAO.getListOfEventsByNameAndDate(eventName,eventDate);
    }

    public List<Event> getListOfEventsBetweenTwoDates(LocalDate firstDate, LocalDate lastDate) {
        return eventDAO.getListOfEventsBetweenTwoDates(firstDate,lastDate);
    }
}
