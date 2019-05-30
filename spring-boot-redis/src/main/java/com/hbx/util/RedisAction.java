package com.hbx.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisAction {

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;


    public String getValue(String key) {
        return (String)redisTemplate.opsForValue().get(key);
    }


    public void SetStringValue(String key, String value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key,value, time);
        }else  {
            redisTemplate.opsForValue().set(key, value);
        }
    }


}
