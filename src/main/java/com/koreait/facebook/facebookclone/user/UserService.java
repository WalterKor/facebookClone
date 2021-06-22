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
    private MySecurityUtils securityUtils;


    public int join(UserEntity param){

        String authCd =  securityUtils.getRandomDigit(5);


        //비밀번호 암호화
        String hashedPw = BCrypt.hashpw(param.getPw(), BCrypt.gensalt());
        param.setPw(hashedPw);
        param.setAuthCd(authCd);
        int result = mapper.join(param);

        if(result == 1){
        //메일 쏜게 확인되면 성공하면 (id, authcd값을 메일로 쏜다.)

            String subject = "[facebook]인증메일";
            String txt = String.format("<a href=\"http://localhost:8090/user/auth?email=%s&authCd=%s\">인증하기</a>"
                    ,param.getEmail(), authCd);
            email.sendMimeMessage(param.getEmail(), subject, txt);

        }

        return result;

    }



    public void sendEmail(){

        String to = "j33515@naver.com";
        String subject = "김상혁";
        String txt = "형";
        email.sendSimpleMessage(to, subject, txt);

    }

    //이메일 인증처리
    public int auth(UserEntity param){

        return mapper.auth(param);

    }




}
