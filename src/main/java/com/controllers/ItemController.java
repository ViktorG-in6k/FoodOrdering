package com.controllers;

import com.serviceLayer.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/new_item", method = RequestMethod.POST)
    public String newItem(HttpServletRequest req, HttpSession session) {
        itemService.saveByRequest(req, session);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }
}
