package com.pages.LoginPage.web;

import com.pages.LoginPage.DAO.UserRepository;
import com.pages.LoginPage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/save")
    public String createUser(User user) {
        userRepository.save(user);

        return "redirect:/list";
    }

    @GetMapping("/list")
    public String showUserList(){
        return "list";
    }

    @PostMapping("/login")
    public String showLogin(User user) {


        return "redirect:/list";
    }


}
