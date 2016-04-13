package com.controllers;

import com.serviceLayer.implementation.EventServiceImpl;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class EventController {
    @Autowired
    EventServiceImpl eventService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/addResponsibleUser",method = RequestMethod.POST)
    public String setResponsibleUser(HttpSession session, @RequestParam("eventId") int eventId){
        int userId = (int) session.getAttribute("userId");
        eventService.setResponsibleUser(userId,eventId);
        return "redirect:/events/";
    }
}

