package com.example.xiaoheihe.controller;

import com.example.xiaoheihe.dao.UserMapper;
import com.example.xiaoheihe.domain.DemoBean;
import com.example.xiaoheihe.domain.LoginUser;
import com.example.xiaoheihe.resultEntity.Result;
import com.example.xiaoheihe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Value("${mq.routingKey}")
    private String routingKey;
    @Value("${mq.directExchange}")
    private String directExchange;
    @Autowired
    private DemoBean demoBean;

    @PostMapping("/query")
    public String query(HttpServletRequest request,HttpServletResponse response){

        return routingKey + " " + directExchange;
    }

//    @PostMapping("/login")
//    public Result login(@RequestBody LoginUser loginUser, HttpServletRequest request, HttpServletResponse response){
//
//        return routingKey + " " + directExchange;
//    }

}
