package com.backspringboot.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.Map;

@RestController

@RequestMapping("/user")
public class LoginController  {
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000") //인터셉터 적용안되서 임시로 추가
    public Object login(@RequestBody Map<String, Object> param,HttpSession session){
        System.out.println("user/domain");
        String email = param.get("email").toString();
        System.out.println("param : "+param);
        System.out.println("email : "+email);
        session.setAttribute("memVo",param);
        return param;
    }
    @PostMapping("/{user}")
    public Object getUser(@RequestBody Map<String, Object> param,HttpSession session){
        System.out.println("session : "+ session.getAttribute("memVo"));
        return session.getAttribute("memVo");
    }

}
