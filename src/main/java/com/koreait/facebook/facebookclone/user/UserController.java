package com.koreait.facebook.facebookclone.user;

import com.koreait.facebook.facebookclone.common.MySecurityUtils;
import com.koreait.facebook.facebookclone.user.model.UserEntity;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

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
        return "redirect:/feed/home";
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
