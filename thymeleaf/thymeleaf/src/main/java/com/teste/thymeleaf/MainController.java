package com.teste.thymeleaf;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class MainController {


    @RequestMapping("/")
    public ModelAndView home(){
        Map<String, Object> model = new HashMap<>();
        model.put("username", "Lucas Palma");
        model.put("id", 13);
        return new ModelAndView("home","model",model);
    }

    @RequestMapping("/profile")
    public ModelAndView viewProfile(){
        Map<String, Object> model = new HashMap<>();
        model.put("title", "Mr.");
        model.put("firstName", "Lucas");
        model.put("surname","Palma");
        model.put("birth", new GregorianCalendar(1992,5,23).getTime());
        model.put("description", "a <strong>fantastic</strong> Java Programmer");

        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("French");
        languages.add("Spanish");

        model.put("languages", languages);
        model.put("color", "#ccc");

        return new ModelAndView("profile","model", model);
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(){
        return new ModelAndView("newUser", "addUserModel", new AddUserModel());
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@Validated AddUserModel addUserModel, BindingResult bindingResult){
        new AddUSerModelValidator().validate(addUserModel,bindingResult);
        if (bindingResult.hasErrors()){
            return "newUser";
        }

        return "userAdded";
    }
}
