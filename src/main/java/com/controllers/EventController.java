package com.controllers;

import com.DTOLayer.DTOEntity.EventDTO;
import com.model.Entity.Event;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Controller
public class EventController {
    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/addResponsibleUser",method = RequestMethod.POST)
    public String setResponsibleUser(HttpSession session, @RequestParam("eventId") int eventId){
        int userId = (int) session.getAttribute("userId");
        eventService.setResponsibleUser(userId,eventId);
        return "redirect:/events/";
    }

    @RequestMapping("/eventsJson/")
    public @ResponseBody
    Set<EventDTO> getEvents() {
        Set<EventDTO> EventDTOs = new HashSet<>();
        for (Event e: eventService.getListOfAllEvents()) {
            EventDTOs.add(new EventDTO(e));
        }
        return EventDTOs;
    }

    @RequestMapping("/event_{id}")
    public @ResponseBody
    EventDTO getEventById(@PathVariable("id") int eventId) {
        EventDTO EventDTO = new EventDTO(eventService.getEventById(eventId));
        return EventDTO;
    }


}
