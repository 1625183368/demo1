package com.example.xiaoheihe.TestMain;

import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) {
        String v1 = "a,b,,";
        String[] strings = new String[6];
        strings = v1.split(",",6);
        System.out.println(strings.length);
    }
}
