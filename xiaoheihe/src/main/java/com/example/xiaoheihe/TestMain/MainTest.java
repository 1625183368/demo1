package com.example.xiaoheihe.TestMain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.xiaoheihe.domain.Demo;
import com.example.xiaoheihe.utils.RsaUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class MainTest {
    public static void main(String[] args) throws Exception {
//        String v1 = "a,b,,";
//        String[] strings = new String[6];
//        strings = v1.split(",",6);
//        System.out.println(strings.length);
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String admin = bCryptPasswordEncoder.encode("admin");
//        System.out.println(admin);
//        String password = "$2a$10$mkqJeBGJIl5cyocz3SYXduClgOCUdm4eDNkDgIko.CY5VjdszIop2";
//        boolean admin = bCryptPasswordEncoder.matches("admin", password);
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

//        TimeUnit seconds = TimeUnit.valueOf("SECONDS");
//        System.out.println(seconds);

//        String str1 = ",,,";
//        String[] split = str1.split(",",1000);
//        System.out.println(split[2]);
        List<String> list = Arrays.asList("111","23123");
        System.out.println(list.contains("0"));
    }

    public static void toDemo2(Demo demo){
        demo.setmRID("123");
//        System.out.println(demo.getmRID());
    }
}
