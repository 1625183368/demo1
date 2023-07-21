package com.example.xiaoheihe.config.pool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
@Slf4j
@PropertySource(value = {"classpath:ThreadPoolParams.properties"})
@ConfigurationProperties(prefix = "threadpool.async")
public class AsyncThreadPoolConfig implements AsyncConfigurer {


    // 核心线程池大小
//    @Value("${threadpool.async}")
    private String corePoolSize;

    // 最大可创建的线程数

    private String maxPoolSize;

    // 队列最大长度
    private String queueCapacity;

    // 线程池维护线程所允许的空闲时间
    private String keepAliveSeconds;

    @Bean("asyncThreadPoolExecutor")
    public ThreadPoolTaskExecutor executor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("asyncThread--");
        threadPoolTaskExecutor.setCorePoolSize(Integer.parseInt(corePoolSize));
        threadPoolTaskExecutor.setMaxPoolSize(Integer.parseInt(maxPoolSize));
        threadPoolTaskExecutor.setQueueCapacity(Integer.parseInt(queueCapacity));
        threadPoolTaskExecutor.setKeepAliveSeconds(Integer.parseInt(keepAliveSeconds));
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }


    @Override
    public Executor getAsyncExecutor() {
        return executor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex,method,params)->log.error("线程池执行任务发送未知错误, 执行方法：{}", method.getName(), ex);
    }


    public String getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(String corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public String getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(String maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public String getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(String queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public String getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(String keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }
}
