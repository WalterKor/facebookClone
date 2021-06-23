package com.koreait.facebook.facebookclone.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserService service;

    @Autowired
    private MySecurityUtils utils;


    @GetMapping("/login")
    public void login(){}

    @GetMapping("/join")
    public void join(@ModelAttribute UserEntity userEntity){ }

    @PostMapping("/join")
    public String joinProc(UserEntity userEntity){
        service.join(userEntity);
        return "redirect:login?reademail=1";
    }


    @GetMapping("/email")
    public String email(){
        service.sendEmail();

        return "";
    }


    @GetMapping("/auth")
    public String auth(UserEntity param){
        int result = service.auth(param);
        return "redirect:login?auth=" + result;
    }





}
