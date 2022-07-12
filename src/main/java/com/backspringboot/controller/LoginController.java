package com.backspringboot.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class LoginController {
    @PostMapping("/login")
    public String login(HttpServletRequest req,Model model, HttpSession session){
        System.out.println("user/domain");
        String email = req.getParameter("email");
        System.out.println("email : "+email);
        return email;
    }
    @RequestMapping("/login")
    public String getLogin(HttpServletRequest req,Model model, HttpSession session){
        System.out.println("user/domain");
        String email = req.getParameter("email");
        System.out.println("email : "+email);
        return email;
    }
}
