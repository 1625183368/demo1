package com.example.xiaoheihe.TestMain;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executors;

public class Singleton {
    private static volatile Singleton instance;
    private static boolean flag = false;
    private Singleton(){
        synchronized (Singleton.class){
            if (!flag){
                flag = true;
            }else {
                throw new RuntimeException("非法创建Singleton");
            }
        }
    }
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Constructor<Singleton> singeltonConstructor = Singleton.class.getDeclaredConstructor();
//        singeltonConstructor.setAccessible(true);
//        Singleton singleton = singeltonConstructor.newInstance();

//        Singleton instance1 = Singleton.getInstance();
//        Singleton instance2 = Singleton.getInstance();

//        System.out.println(singleton==instance1?"01":"-");
//        System.out.println(singleton==instance2?"02":"-");
//        System.out.println(instance1==instance2?"12":"-");

        String str1 = "abc";  //常量池
        String str2 = new String("abc"); //堆
        str1 = str1.intern(); //常量池的引用 堆的地址


        System.out.println(str1 == str2.intern() ? "12" : "");

    }

}
