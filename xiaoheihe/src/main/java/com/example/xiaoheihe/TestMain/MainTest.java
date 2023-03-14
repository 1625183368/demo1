package com.example.xiaoheihe.TestMain;

import com.example.xiaoheihe.domain.Demo;
import com.example.xiaoheihe.utils.RsaUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public static void main(String[] args) throws Exception {
//        String v1 = "a,b,,";
//        String[] strings = new String[6];
//        strings = v1.split(",",6);
//        System.out.println(strings.length);
//        String admin = new BCryptPasswordEncoder().encode("admin");
//        System.out.println(admin);
//        ItextTest itextTest = new ItextTest();
//        String keyPath = itextTest.getClass().getClassLoader().getResource("").getPath();
//
//        System.out.println(keyPath);
//        String privateKey = keyPath + "config/auth_key/"+"id_key_rsa2";
//
//        String publicKey = keyPath + "config/auth_key/"+"id_key_rsa2.pub";
//        RsaUtils.generateKey(publicKey,privateKey,"demo2",1024);
//        Demo demo = new Demo();
//        toDemo2(demo);
//        System.out.println(demo.getmRID());
//        demo.setmRID("1234");
//        System.out.println(demo.getmRID());

        TimeUnit seconds = TimeUnit.valueOf("SECONDS");
        System.out.println(seconds);
    }

    public static void toDemo2(Demo demo){
        Demo demo2 = new Demo();
        demo2.setmRID("123");
        demo = demo2;
//        System.out.println(demo.getmRID());
    }
}
