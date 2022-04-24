package com.bobo.controller;

import com.bobo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUserInfo")
    public Map<String,Object> getUserInfo(){
        Map<String,Object> resMap = new HashMap<>();
        Map<String, Object> userData = userService.getUserData();

        resMap.put("code",200);
        resMap.put("data",userData);
        return resMap;
    }
}
