package com.serviceLayer.implementation;

import com.DTOLayer.DTOEntity.EventDTO;
import com.DTOLayer.DTOEntity.RequestEventDTO;
import com.dataLayer.DAO.EventDAO;
import com.model.Entity.Event;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventDAO eventDAO;
    @Autowired
    UserService userService;

    public void save(RequestEventDTO eventDTO) {
        if (eventDTO.getImageURL().equals("")) {
            if (eventDTO.getDate().getHour() > 12 && eventDTO.getDate().getHour() < 16) {
                eventDTO.setImageURL("/resources/image/lanch.jpg");
            } else if (eventDTO.getDate().getHour() > 16 || (eventDTO.getDate().getHour() > -1 && eventDTO.getDate().getHour() < 5)) {
                eventDTO.setImageURL("/resources/image/food.jpg");
            } else {
                eventDTO.setImageURL("/resources/image/breakfast.jpg");
            }
        }
        Event newEvent = new Event(eventDTO);
        eventDAO.save(newEvent);
    }

    public Event getEventById(int id) {
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
        return eventDAO.getListOfEventsByNameAndDate(eventName, eventDate);
    }

    public List<Event> getListOfEventsBetweenTwoDates(LocalDate firstDate, LocalDate lastDate) {
        return eventDAO.getListOfEventsBetweenTwoDates(firstDate, lastDate);
    }

    public void update(Event event) {
        eventDAO.update(event);
    }

    public void setResponsibleUser(int userId, int eventId) {
        Event eventById = getEventById(eventId);
        eventById.setUser(userService.getUser(userId));
        update(eventById);
    }

    public void saveByRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        String description = req.getParameter("discript");

        String URLimage = req.getParameter("image");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime date = LocalDateTime.parse(req.getParameter("date"), formatter);

        Event event = new Event(name, description, URLimage, date);
        eventDAO.save(event);
    }
}

