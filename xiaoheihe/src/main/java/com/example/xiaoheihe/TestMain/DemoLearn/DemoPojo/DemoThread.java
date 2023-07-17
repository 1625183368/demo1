package com.example.xiaoheihe.TestMain.DemoLearn.DemoPojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;


public class DemoThread implements Callable {
    private static Logger log = LoggerFactory.getLogger(DemoThread.class);
    @Override
    public Object call() throws Exception {

        return null;
    }
    private int seal(int num){
        log.info("售出票：{}",num);
        return num--;
    }

}
