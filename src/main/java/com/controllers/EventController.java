package com.controllers;

import com.DTOLayer.DTOEntity.EventDTO;
import com.DTOLayer.DTOEntity.RequestEventDTO;
import com.model.Entity.Event;
import com.model.Entity.User;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Controller
public class EventController {
    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/addResponsibleUser", method = RequestMethod.POST)
    public String setResponsibleUser(HttpSession session, @RequestParam("eventId") int eventId) {
        int userId = (int) session.getAttribute("userId");
        eventService.setResponsibleUser(userId, eventId);
        return "redirect:/events/";
    }

    @RequestMapping("/eventsJson/")
    public @ResponseBody Set<EventDTO> getEvents(HttpSession session) {
        Set<EventDTO> EventDTOs = new HashSet<>();
        User user = userService.getUser((int) session.getAttribute("userId"));
        for (Event event : eventService.getListOfAllEvents()) {
            EventDTOs.add(new EventDTO(event, user));
        }
        return EventDTOs;
    }

    @RequestMapping("/event_{id}")
    public @ResponseBody EventDTO getEventById(@PathVariable("id") int eventId, HttpSession session) {
        User user = userService.getUser((int) session.getAttribute("userId"));
       return new EventDTO(eventService.getEventById(eventId), user);
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public String events(HttpSession session, HttpServletRequest req) {
        String email = req.getParameter("email");
        session.setAttribute("backPage", "/");
        userService.saveUser(email);

        session.setAttribute("userId", userService.getUserByEmail(req.getParameter("email")).getId());
        return "events";
    }

    @RequestMapping(value = "/new_event", method = RequestMethod.POST)
    public @ResponseBody Set<EventDTO> newEvent(@RequestBody RequestEventDTO event, HttpServletRequest req, HttpSession session) {
        eventService.save(event);
        return getEvents(session);
    }

    @RequestMapping(value = "/events")
    public String events(HttpSession session) {

        session.setAttribute("allEvents", eventService.getListOfAllEvents());
        session.setAttribute("backPage", "/events");
        return "events";
    }

    @RequestMapping(value = "/newEvent", method = RequestMethod.GET)
    public @ResponseBody String createEvent(@RequestParam("name") String name, @RequestParam("date") String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);

        System.out.println(localDateTime);
        return "ok";
    }
}

