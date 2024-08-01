package com.example.xiaoheihe.TestMain.threaddemo.entity;

import java.io.Serializable;

public class ThreadPool implements Serializable {
    private static volatile ThreadPool instance;
    private static boolean flag = false;


    private ThreadPool(){
        synchronized (ThreadPool.class){
            if (!flag){
                flag = true;
            }else {
                throw new RuntimeException("非法创建ThreadPool");
            }
        }
    }

    public static ThreadPool getInstance(){
        if (instance != null){
            synchronized (ThreadPool.class){
                if (instance == null) {
                    instance = new ThreadPool();
                }
            }
        }
        return instance;
    }

}
