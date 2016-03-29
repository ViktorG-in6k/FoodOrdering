package com.controllers;

import com.model.User;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    EventService eventService;

    @RequestMapping(value = "/")
    public String getMain(Model model) {
        return "hello";
    }

    @RequestMapping(value = "/sing_in")
    public String sing_in(HttpServletRequest req, HttpSession session) {
        String email = req.getParameter("email");
        User person = new User("User",email);

        if(userService.getUserByEmail(email)==null){
            userService.saveUser(person);
            String ref  = req.getHeader("Referer");
            return "redirect:"+ref;
        }
        else {
            session.setAttribute("userMail",email);
            session.setAttribute("allEvents",eventService.getListOfAllEvents());
            return "main";
        }
    }

    @RequestMapping(value = "/sing_out")
    public String sing_out(HttpSession session) {
        session.setAttribute("userMail",null);
        return "hello";
    }

    @RequestMapping(value = "/new_Event")
    public String new_Event(HttpServletRequest req, HttpSession session, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate localDate ) {

        String name = req.getParameter("name");
        String description = req.getParameter("discript");
        String URLimage = req.getParameter("image");
        //LocalDate date =  localDate;
        System.out.println(name);
        System.out.println(description);
        System.out.println(URLimage);
        //System.out.println(date);
        String ref  = req.getHeader("Referer");
        return "redirect:"+ref;
    }
}
