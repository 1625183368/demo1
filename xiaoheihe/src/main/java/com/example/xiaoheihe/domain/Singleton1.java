package com.example.xiaoheihe.domain;

public class Singleton1 {
    private volatile static Singleton1 singleton;
    public static Singleton1 getSingleton1(){
        if (singleton == null){
            synchronized (Singleton1.class){
                if (singleton == null){
                    singleton = new Singleton1();
                }
            }
        }
        return singleton;
    }
}
