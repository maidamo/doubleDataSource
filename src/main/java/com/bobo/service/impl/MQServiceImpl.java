package com.bobo.service.impl;

import com.bobo.service.MqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MQServiceImpl implements MqService {

    private static Logger log = LoggerFactory.getLogger(MQServiceImpl.class);

    private static final String MESSAGE_KEY = "message:queue";

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public String produce(String string) {
        Long aLong = redisTemplate.opsForList().leftPush(MESSAGE_KEY, string);
        if (aLong > 0){
            log.info("produce : {}", string);
            return "sucess";
        }
        return "failure";
    }

    @Override
    public String consume() {
        String string = (String) redisTemplate.opsForList().rightPop(MESSAGE_KEY);
        log.info("consume : {}", string);
        return string;
    }
}
