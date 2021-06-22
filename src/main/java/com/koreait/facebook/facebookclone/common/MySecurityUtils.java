package com.koreait.facebook.facebookclone.common;

import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class MySecurityUtils {

    public int getRandomNumber(int sNumber, int eNumber){
        return (int)(Math.random() * (eNumber-sNumber))+(sNumber+1);
    }

    //len길이만큼의 랜덤한 숫자

    public String getRandomDigit(int len){
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<len ; i++){
            sb.append(getRandomNumber(0,9));
        }

//        Random rnd = new Random();
//        int number = rnd.nextInt(999999);
//        return String.format("%06d", number);
        return sb.toString();
    }

    /*
    //숫자 + 영문자 랜덤하게 만드는 문자열 리턴 10 > "1adaga7"
    public String getRandomString(){
        UUID를 통해서 간단하게 쉽게 만들 수 있을 것이다.
    }
    */


}
