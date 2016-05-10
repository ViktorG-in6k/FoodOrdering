package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

}

