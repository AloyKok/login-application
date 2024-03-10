package com.aloysiouskok.loginapplication.controller;

import com.aloysiouskok.loginapplication.model.UserModel;
import com.aloysiouskok.loginapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("error", null);
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {

        if (userService.isValidUser(username, password)) {
            UserModel user = userService.findByUsername(username).get();
            model.addAttribute("user", user);
            return "welcome";
        } else {
            model.addAttribute("error", "Invalid userid or password");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
