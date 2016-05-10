package com.controllers;

import com.googleAuthentication.CurrentUserDetails;
import com.model.Entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @RequestMapping(value = "/partials/{part}")
    public String getPartialPage(@PathVariable("part") String part) {
        return "partials/" + part;
    }

    @RequestMapping(value = "/")
    public String getMain() {
        return "main";
    }

    @RequestMapping(value = "/getCurrentUser")
    public @ResponseBody String getCurrentUserEmail(Authentication authentication) {
       return ((User) authentication.getPrincipal()).getEmail();
    }

}

