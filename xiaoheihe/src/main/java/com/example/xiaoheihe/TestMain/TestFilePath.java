package com.example.xiaoheihe.TestMain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

public class TestFilePath {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InterruptedException {
//        ClassPathResource resource = new ClassPathResource("现场记录单" + UUID.randomUUID().toString() + ".docx");
//        File file = new File("现场记录单" + UUID.randomUUID().toString() + ".docx");
//        String path = file.getPath();
//        System.out.println(path);
//        String absPath = file.getAbsolutePath();
//        System.out.println(absPath);

//        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
//        System.out.println((int) Math.round(Math.random()*2));
//        System.out.println((int) Math.round(random.nextDouble()*2));
        Object lock = new Object();

        Logger logger = LoggerFactory.getLogger("TestFilePath");
        long startTime = System.currentTimeMillis();
        System.out.print("[");

        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(10);
        threadPoolExecutor.setMaxPoolSize(20);
        threadPoolExecutor.setQueueCapacity(200);
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.initialize();
            for (int i = 0; i < 100; i++) {
//            Thread.sleep(100);
                threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName() + "□"));
//                logger.info("□");
            }
        System.out.println("耗时" + (System.currentTimeMillis() - startTime));
//        threadPoolExecutor.shutdown();

    }
}
