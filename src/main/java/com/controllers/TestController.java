package com.controllers;

import com.model.Entity.User;
import com.serviceLayer.service.UserService;
import com.splitBill.SplitBillApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class TestController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/test")
    public @ResponseBody String splitBillTest(HttpSession session) throws IOException {
        SplitBillApi splitBillApi = new SplitBillApi();
        User user = userService.getUser((int) session.getAttribute("userId"));
        splitBillApi.login(user.getEmail());
        System.out.println(user.getEmail());

        splitBillApi.newBill(841);
        return "OK";
    }
}
