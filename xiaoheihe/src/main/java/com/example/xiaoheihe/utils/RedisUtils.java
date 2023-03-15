package com.example.xiaoheihe.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {
    private static final Logger log = LoggerFactory.getLogger(RedisUtils.class);

    @Value("${spring.redis.login.token.prefix}")
    private String REDISLOGINTOKENPREFIX;
    @Value("${spring.redis.login.token.timeout}")
    private String timeOut;
    @Value("${spring.redis.login.token.timeunit}")
    private String timeUnit;

    public String getTokenPrefix(){
        return this.REDISLOGINTOKENPREFIX;
    }
    public Long getTimeOut(){
        return Long.parseLong(this.timeOut);
    }
    public TimeUnit getTimeUnit(){
        return TimeUnit.valueOf(this.timeUnit);
    }

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public Object get(final String key){
        log.info("redis-get-key: {}",key);
        if (StringUtils.isEmpty(key)){
            return null;
        }
        try {
            return redisTemplate.opsForValue().get(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public <T> boolean set(final String key,T value){
        log.info("redis-set-key: {} , value: {}",key,value);
        if (StringUtils.isEmpty(key)){
            return false;
        }
        try {
            redisTemplate.opsForValue().set(key, value);
            log.info("redis存储成功");
            return true;
        }catch (Exception e){
            log.error("redis存储失败");
            e.printStackTrace();
        }
        return false;
    }
    public <T> boolean set(final String key, T value, long timeout, TimeUnit timeUnit){
        log.info("redis-set-key: {} , value: {}",key,value);
        if (StringUtils.isEmpty(key)){
            return false;
        }
        try {
            redisTemplate.opsForValue().set(key, value,timeout,timeUnit);
            log.info("redis存储成功");
            return true;
        }catch (Exception e){
            log.error("redis存储失败");
            e.printStackTrace();
        }
        return false;
    }

    public boolean expire(final String key,long timeout,TimeUnit timeUnit){
        log.info("redis-set-key: {},续租{}{}",key,timeout,timeUnit.name());
        if (StringUtils.isEmpty(key)){
            return false;
        }
        try {
            redisTemplate.expire(key,timeout,timeUnit);
            log.info("redis续租成功");
        }catch (Exception e){
            log.error("redis续租失败");
            e.printStackTrace();
        }
        return false;
    }
}
