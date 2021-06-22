package com.koreait.facebook.facebookclone.user;

import com.koreait.facebook.facebookclone.common.EmailServiceImpl;
import com.koreait.facebook.facebookclone.common.MySecurityUtils;
import com.koreait.facebook.facebookclone.user.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private EmailServiceImpl email;

    @Autowired
    private MySecurityUtils utils;


    public int join(UserEntity param){
        //비밀번호 암호화
        String hashedPw = BCrypt.hashpw(param.getPw(), BCrypt.gensalt());
        param.setPw(hashedPw);
        return mapper.join(param);
    }



    public void sendEmail(){

        String to = "j33515@naver.com";
        String subject = "김상혁";
        String txt = "형";
        email.sendSimpleMessage(to, subject, txt);

    }



}
