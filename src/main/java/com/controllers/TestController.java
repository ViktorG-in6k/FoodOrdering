package com.controllers;

import com.splitBill.SplitBillApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping(value = "/test")
    public @ResponseBody String splitBillTest() {
        SplitBillApi splitBillApi = new SplitBillApi();
        splitBillApi.login("user@example.com");
        return "OK";
    }

}
