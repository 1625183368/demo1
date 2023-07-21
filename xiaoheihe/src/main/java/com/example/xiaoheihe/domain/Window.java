package com.example.xiaoheihe.domain;

import java.util.concurrent.locks.ReentrantLock;

public class Window implements Runnable{
    private static int ticket = 500;
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticket <= 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "卖了第" + ticket + "张票");
            ticket--;
            lock.unlock();
        }
    }

}
