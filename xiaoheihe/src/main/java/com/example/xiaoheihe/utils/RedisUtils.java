package com.example.xiaoheihe.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {
    private static final Logger log = LoggerFactory.getLogger(RedisUtils.class);

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

    public boolean set(final String key,Object value){
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
    public boolean set(final String key, Object value, long timeout, TimeUnit timeUnit){
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
}
