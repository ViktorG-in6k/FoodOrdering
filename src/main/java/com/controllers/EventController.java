package com.controllers;


import com.model.Event;
import com.serviceLayer.implementation.EventServiceImpl;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class EventController {
    @Autowired
    EventServiceImpl eventService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/addResponsibleUser",method = RequestMethod.POST)
    public @ResponseBody String setResponsibleUser(HttpSession session, @RequestParam("eventId") int evetnId){

        int userId = (int) session.getAttribute("userId");
        Event eventById = eventService.getEventById(evetnId);
        eventById.setUser(userService.getUser(userId));
        eventService.update(eventById);

        return "ok";
    }
}
