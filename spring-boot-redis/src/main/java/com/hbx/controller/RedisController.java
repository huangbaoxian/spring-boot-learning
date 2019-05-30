package com.hbx.controller;

import com.hbx.util.RedisAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class RedisController {

    @Autowired
    private RedisAction redisAction;

    @RequestMapping("/getvalue")
    @ResponseBody
    public String redisGetValue(String key) {
        return redisAction.getValue(key);
    }

    @RequestMapping("/setvalue")
    @ResponseBody
    public String redisSetValue(String key, String value) {
        System.out.print("key:" + key + "  value:" + value);
        try {
            redisAction.SetStringValue(key, value, 0);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }


}
