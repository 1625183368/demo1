package com.example.xiaoheihe.TestMain;

import com.example.xiaoheihe.enums.DeviceHealthCodeScoreType;
import com.example.xiaoheihe.exceptions.DemoException;

public class DemoExceptionTest {
    public static void main(String[] args) {
//        try {
//            testEx();
//        }catch (DemoException e){
//            System.out.println("msg: " + e.getMsg() + "\n" + "data: " + e.getData());
//        }
        System.out.println(DeviceHealthCodeScoreType.GYSHDM.toString());
    }

    public static void testEx() throws DemoException {
        int i = 0;
        if (false) {
            System.out.println(i);
        }else throw new DemoException("抛异常",i);
    }
}
