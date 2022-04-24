package com.bobo.controller;

import com.alibaba.druid.util.StringUtils;
import com.bobo.service.MqService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api")
public class MqController {

    @Resource
    private MqService mqService;

    @GetMapping(value = "/produce")
    public String produce(@RequestParam(name = "key") String key) {
        return mqService.produce(key);
    }

    @GetMapping(value="/consume")
    public String consume() throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        sb.append("action:");
        while (true) {
            String consume = mqService.consume();
            if (StringUtils.isEmpty(consume)) {
                break;
            }
            sb.append(consume);
            Thread.sleep(3000);
        }
        return sb.toString();
    }
}
