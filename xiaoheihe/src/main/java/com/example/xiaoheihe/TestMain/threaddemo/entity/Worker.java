package com.example.xiaoheihe.TestMain.threaddemo.entity;

public class Worker implements Runnable{


    @Override
    public void run() {
        System.out.println("worker " + Thread.currentThread().getName() + "开始工作");

        try {
            Thread.sleep(1000);
            System.out.println("worker " + Thread.currentThread().getName() + "工作完成");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
