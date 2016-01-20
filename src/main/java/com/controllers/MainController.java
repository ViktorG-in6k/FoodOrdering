package com.controllers;

import com.model.Person;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/")
    public String getMain(Model model) {
        Person person = new Person("user");
        personService.savePerson(person);
        Person savePerson = personService.getPerson(person.getId());
        model.addAttribute("name", savePerson.getName() + " " + savePerson.getId());
        return "hello";
    }

    @RequestMapping(value = "/hello")
    public
    @ResponseBody
    String getMai() {
        return "work hello";
    }

}
