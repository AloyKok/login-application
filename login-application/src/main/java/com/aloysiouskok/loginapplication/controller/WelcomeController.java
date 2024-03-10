package com.aloysiouskok.loginapplication.controller;

import com.aloysiouskok.loginapplication.model.UserModel;
import com.aloysiouskok.loginapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class WelcomeController {

    private UserService userService;

    @GetMapping("/welcome")
    public String welcome(Model model, Principal principal) {
        UserModel user = userService.findByUsername(principal.getName()).get();
        model.addAttribute("user", user);
        return "welcome";
    }

    @GetMapping("/restricted")
    public String restricted(Model model, Principal principal) {
        Optional<UserModel> user = null;
        if(principal != null)
        {
            String username = principal.getName();
            user = userService.findByUsername(username);
            if (!user.get().getRole().equals("manager")) {
                model.addAttribute("error", "You are not authorized to access this page");
                return "welcome";
            }
        }
        model.addAttribute("user", user);
        return "restricted";
    }
}
