package com.example.xiaoheihe.TestMain;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadTest {

//    public static void main(String[] args) throws InterruptedException {
//        //死循环 导致HashMap的Entry链表形成环 一旦成环,Entry的next节点永远不为空
//        final HashMap<String, String> map = new HashMap<>(2);
//        Thread t = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                new Thread(() -> map.put(UUID.randomUUID().toString(), ""), "moon" + i).start();
//            }
//        }, "ftf");
//        t.start();
//        t.join();
//        System.out.println(map.keySet());
//    }
    public static void main(String[] args) throws InterruptedException {


//        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setCorePoolSize(5);
//        threadPoolTaskExecutor.setMaxPoolSize(10);
//        threadPoolTaskExecutor.setQueueCapacity(100);
//        threadPoolTaskExecutor.setKeepAliveSeconds(500);
//        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        threadPoolTaskExecutor.initialize();
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        StringBuffer sb = new StringBuffer();
//        for (int i=0; i<100 ; i++) {
//            threadPoolTaskExecutor.submit(() -> {
//                sb.append("ab").append("*********").append(Thread.currentThread().getName());
//                System.out.println(sb.toString());
//                countDownLatch.countDown();
//                sb.setLength(0);
//            });
//        }
//
//        countDownLatch.await();
//        threadPoolTaskExecutor.shutdown();
        System.out.println(String.format("start%s45678:%d%%","图片",10));


//        int i = 0;
//        ArrayList<Integer> list = new ArrayList<>();
//
//        while (i<10000){
//            list.add(i);
//            i++;
//        }

//        for (Integer j : list){
//            threadPoolTaskExecutor.execute(()->{
//                System.out.println(Thread.currentThread().getName()+ "    " + j +"a");
//            });
//        }


    }

}
