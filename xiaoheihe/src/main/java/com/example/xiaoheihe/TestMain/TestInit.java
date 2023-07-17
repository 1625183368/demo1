package com.example.xiaoheihe.TestMain;

public class TestInit {
    static class DeadLoopClass {
        static {
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (true) {
                }
            }
        }
        public static int i;
    }
    public static void main(String[] args) {
        Runnable script = () -> {
            System.out.println(Thread.currentThread() + "start");
            new DeadLoopClass();
            System.out.println(Thread.currentThread() + " run over");
        };
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
        Object o = new Object();
        System.out.println(o);
    }
}
