package com.controllers;

import com.dataLayer.entity.base.User;
import com.serviceLayer.googleAuthentication.CurrentUserDetails;
import com.serviceLayer.service.UserService;
import com.dataLayer.entity.external.SplitBillApi;
import com.dataLayer.splitBillDTO.product.ProductRequestJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.math.BigDecimal;

@Controller
public class SplitBillController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/test")
    public @ResponseBody String addBillToEvent(Authentication authentication) throws IOException {
        SplitBillApi splitBillApi = new SplitBillApi();

        User user = userService.getUser(getCurrentUserId(authentication));
        splitBillApi.login(user.getEmail());

        splitBillApi.newBill(831);

        ProductRequestJSON productRequestJSON = new ProductRequestJSON(5,"banasssn",new BigDecimal(14.55));

        splitBillApi.newProduct(productRequestJSON);
        productRequestJSON = new ProductRequestJSON(5,"aaa",new BigDecimal(14.55));

        splitBillApi.newProduct(productRequestJSON);
        return "OK";
    }

    private int getCurrentUserId(Authentication authentication) {
        return ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId();
    }
}

