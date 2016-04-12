package com.controllers;


import com.serviceLayer.implementation.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EventController {
    @Autowired
    EventServiceImpl eventService;


}