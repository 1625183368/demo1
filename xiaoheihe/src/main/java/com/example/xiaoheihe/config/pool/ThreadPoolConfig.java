package com.example.xiaoheihe.config.pool;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Component
@PropertySource(value = {"classpath:ThreadPoolParams.properties"})
@ConfigurationProperties(prefix = "threadpool")
public class ThreadPoolConfig {
    // 核心线程池大小
    private String corePoolSize;

    // 最大可创建的线程数
    private String maxPoolSize;

    // 队列最大长度
    private String queueCapacity;

    // 线程池维护线程所允许的空闲时间
    private String keepAliveSeconds;


    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Integer.parseInt(corePoolSize));
        executor.setMaxPoolSize(Integer.parseInt(maxPoolSize));
        executor.setQueueCapacity(Integer.parseInt(queueCapacity));
        executor.setKeepAliveSeconds(Integer.parseInt(keepAliveSeconds));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
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
