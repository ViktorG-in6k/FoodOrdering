package com.controllers;

import com.DTOLayer.DTOEntity.eventDTO.EventDTO;
import com.DTOLayer.DTOEntity.eventDTO.RequestEventDTO;
import com.googleAuthentication.CurrentUserDetails;
import com.model.Entity.Event;
import com.model.Entity.User;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Controller
public class EventController {
    @Autowired
    EventService eventService;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public
    @ResponseBody
    Set<EventDTO> getComingEvents(Authentication authentication) {
        Set<EventDTO> EventDTOs = new HashSet<>();
        User user = (CurrentUserDetails) authentication.getPrincipal();
        System.out.println(user.getEmail());
        for (Event event : eventService.getListOfAllEvents()) {
            EventDTOs.add(new EventDTO(event, user));
        }
        return EventDTOs;
    }

    @RequestMapping("/event_{id}")
    public
    @ResponseBody
    EventDTO getEventById(@PathVariable("id") int eventId, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return new EventDTO(eventService.getEventById(eventId), user);
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public
    @ResponseBody
    Set<EventDTO> createEvent( @RequestParam("name") String name, Authentication authentication,
                              @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime localDateTime) {
        int userId = getCurrentUserId(authentication);
        eventService.save(new RequestEventDTO(name, localDateTime), userId);
        return getComingEvents(authentication);
    }

    private int getCurrentUserId(Authentication authentication) {
        return ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId();
    }
}


