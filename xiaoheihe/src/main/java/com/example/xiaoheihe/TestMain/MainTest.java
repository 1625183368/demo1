package com.example.xiaoheihe.TestMain;

import com.example.xiaoheihe.domain.Demo;
import com.example.xiaoheihe.utils.RsaUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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







        String str = "%sa%sD%sCfer%sLui%s";
        String result = str;

        char[] cArray = {'B', 'D', 'F'};
        int j = 0;
        //统计%s出现的次数
        for (int i = 0; true; i++) {
            i = str.indexOf("%s", i);
            if (i != -1) {
                j++;
                int index = j % cArray.length;
                if (index == 0) {
                    result = result.replaceFirst("%s", String.valueOf(cArray[cArray.length-1]));
                }else {
                    result = result.replaceFirst("%s",String.valueOf(cArray[index-1]));
                }
            } else {
                break;
            }
        }








//        if (j > 0) {
//            //循环次数
//            int count = j / cArray.length;
//            int index = j % cArray.length;
//            for (int i = 0; i < count; i++) {
//                for (char c : cArray) {
//                    result = result.replaceFirst("%s", String.valueOf(c));
//                }
//            }
//            //补全
//            if (index > 0) {
//                for (int i = 0; i < index; i++) {
//                    result = result.replaceFirst("%s", String.valueOf(cArray[i]));
//                }
//            }
//        }
//        List<String> list = Arrays.asList("a", "s", "c");
        System.out.println(str + " ---> " + result);
    }

    public static void toDemo2(Demo demo){
        Demo demo2 = new Demo();
        demo2.setmRID("123");
        demo = demo2;
//        System.out.println(demo.getmRID());
    }
}
