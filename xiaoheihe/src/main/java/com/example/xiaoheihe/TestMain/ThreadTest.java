package com.example.xiaoheihe.TestMain;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ThreadPoolExecutor;

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
    public static void main(String[] args) {


        int i = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (i<10000){
            list.add(i);
            i++;
        }

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(50);
        threadPoolTaskExecutor.setKeepAliveSeconds(500);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.initialize();

        for (Integer j : list){
            threadPoolTaskExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+ "    " + j +"a");
            });
        }

    }
}
