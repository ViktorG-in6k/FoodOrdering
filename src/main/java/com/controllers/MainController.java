package com.controllers;

import com.model.user;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String getMain(Model model) {
//         user person = new user("Viktor","ViktorG@softwareplanet.uk.com");
//         userService.saveUser(person);
//        user saveUser = userService.getUser(person.getId());
//        model.addAttribute("name", saveUser.getName() + " " + saveUser.getId());
        return "hello";
    }
//    @RequestMapping(value = "/add")
//    public String addToOrder(HttpSession session, HttpServletRequest req, @RequestParam("product") int id) {
//        Order order;
//        if(session.getAttribute("order")==null){
//            order = new Order();
//        }
//        else{
//            order = (Order) session.getAttribute("order");
//        }
//        order.addToOrder(new DataForShoppingCart(productService.getProduct(id),1));
//
//        session.setAttribute("order",order);
//        System.out.println(order.getTotalPrice());
//        System.out.println(order.getOrder().size());
//        String ref  = req.getHeader("Referer");
//        return "redirect:"+ref;
//    }
    @RequestMapping(value = "/sing_in")
    public String sing_in(HttpServletRequest req, HttpSession session) {
        String email = req.getParameter("email");
        user person = new user("User",email);

        if(userService.getUserByEmail(email)==null){
            userService.saveUser(person);
            ла
        }
        else {
            session.setAttribute("userMail",email);
            return "main";
        }

    }

    @RequestMapping(value = "/sing_out")
    public String sing_out(HttpSession session) {
        session.setAttribute("userMail",null);
        return "hello";
    }
}
