package com.controllers;

import com.model.Entity.User;
import com.serviceLayer.service.UserService;
import com.splitBill.SplitBillApi;
import com.splitBill.splitBillDTO.product.ProductRequestJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

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
        ProductRequestJSON productRequestJSON = new ProductRequestJSON(5,"banasssn",new BigDecimal(14.55));
        splitBillApi.newProduct(productRequestJSON);
        return "OK";
    }
}

