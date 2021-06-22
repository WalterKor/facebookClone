package com.koreait.facebook.facebookclone.common;

import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class MySecurityUtils {

    //len길이만큼의 랜덤한 숫자
    public String getRandomValue(int len){

        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        return String.format("%06d", number);
    }

}
