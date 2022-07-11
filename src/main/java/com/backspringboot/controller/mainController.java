package com.backspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mainController {
    String[] names = {"kim","lee"};
    String[] mails = {"abc@naver.com","def@naver.com"};
    @RequestMapping("/")
    public String index(Model model){
        String header = "<html><body>";
        String body = "</body></html>";
        String contents = "index";
        model.addAttribute("hello","서버에서 보내준 값입니다");

        return "index";
    }
    @RequestMapping("/{id}")
    public DataObject num(@PathVariable int id)  {
        try {
            return new DataObject(id,names[id],mails[id]);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Not Found");
        }

    }
}

class DataObject{
    private int id;
    private String name;
    private String password;
    private String value;
    public DataObject(int id, String name, String value){
        super();
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
