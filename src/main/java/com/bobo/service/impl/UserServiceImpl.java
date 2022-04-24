package com.bobo.service.impl;

import com.bobo.dao.master.UserDao;
import com.bobo.dao.slave.TestDao;
import com.bobo.domain.ProductOrder;
import com.bobo.domain.UserInfo;
import com.bobo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private TestDao testDao;

    @Override
    public Map<String,Object> getUserData() {
        int data1 = userDao.getData();
        System.out.println(data1);
        System.out.println("----------------------------");
        int data2 = testDao.getData();
        System.out.println(data2);
        Map<String,Object> map = new HashMap<>();
        map.put("data1",data1);
        map.put("data2",data2);
        return map;
    }
}
