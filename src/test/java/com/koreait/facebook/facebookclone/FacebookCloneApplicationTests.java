package com.koreait.facebook.facebookclone;

import com.koreait.facebook.facebookclone.common.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FacebookCloneApplicationTests {

    @Autowired
    private EmailService emailService;

    @Test
    void sendEmail() {
        String to = "j33515@naver.com";
        String subject = "제목입니다";
        String txt = "내용입니다";
        emailService.sendSimpleMessage(to, subject, txt);
    }

}
