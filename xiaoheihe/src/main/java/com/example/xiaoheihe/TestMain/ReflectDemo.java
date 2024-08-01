package com.example.xiaoheihe.TestMain;

import com.example.xiaoheihe.dejian.Demo1;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

public class ReflectDemo {

    public static void main(String[] args) {
//        MethodHandles.lookup();
        String str = "2312&v202401";
        System.out.println(str.substring(str.indexOf("&")+1,str.indexOf("&")+8));
    }
}
