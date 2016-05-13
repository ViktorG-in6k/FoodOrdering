package com.controllers;

import com.serviceLayer.googleAuthentication.CurrentUserDetails;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class SplitBillController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/test")
    public @ResponseBody String addBillToEvent(Authentication authentication) throws IOException {
        return "OK";
    }

    private int getCurrentUserId(Authentication authentication) {
        return ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId();
    }
}

