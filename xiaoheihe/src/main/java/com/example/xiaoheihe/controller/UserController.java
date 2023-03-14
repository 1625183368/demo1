package com.example.xiaoheihe.controller;

import com.example.xiaoheihe.dao.UserMapper;
import com.example.xiaoheihe.domain.Demo;
import com.example.xiaoheihe.domain.DemoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Value("${mq.routingKey}")
    private String routingKey;
    @Value("${mq.directExchange}")
    private String directExchange;
    @Autowired
    private DemoBean demoBean;

    @PostMapping("/welcome")
    public String query(HttpServletRequest request,HttpServletResponse response){
        return routingKey + " " + directExchange;
    }
}
