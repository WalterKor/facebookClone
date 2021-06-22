package com.koreait.facebook.facebookclone;

import com.koreait.facebook.facebookclone.common.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.rmi.CORBA.Util;

@SpringBootTest
class FacebookCloneApplicationTests {

    @Autowired
    private EmailService emailService;

    @Test
    void sendEmail() {
        String to = "j33515@naver.com";
        String subject = "제목입니다";
        String txt = "내용입니다. <a href=\"http://localhost:8090/user/login\">로그인으로이동</a>";
        emailService.sendMimeMessage(to, subject, txt);
    }

}
