package com.example.xiaoheihe.TestMain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestException {
    public static final Logger log = LoggerFactory.getLogger(TestException.class);
    public static void main(String[] args) {

        try {
            int i = 1/0;
            System.out.println("123213");
        }catch (Exception e){
            log.error("err",e);
            System.out.println("error");
        }
        System.out.println("错误");
    }
    public static void Logerror(Exception e){
        e.printStackTrace();
    }
}
