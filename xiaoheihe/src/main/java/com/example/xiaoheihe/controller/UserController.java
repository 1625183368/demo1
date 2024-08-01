package com.example.xiaoheihe.controller;

import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpHeader;
import com.example.xiaoheihe.dao.UserMapper;
import com.example.xiaoheihe.domain.DemoBean;
import com.example.xiaoheihe.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
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

    @PostMapping("/getAdminToken")
    public String query() throws Exception {
        String url = "http://localhost:8786/xiaoheihe/login";
        Header[] headers = HttpHeader.custom().contentType("application/json").build();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "admin");
        jsonObject.put("password", "admin");
        demoBean.destroy();
        HttpConfig config = HttpConfig.custom()
                .headers(headers)
                .url(url)
                .json(jsonObject.toJSONString());
//                .map(new HashMap<String, Object>() {{
//                    put("username", "admin");
//                    put("password", "admin");
//                }});
        String post = HttpClientUtil.post(config);
        System.out.println(post);
        return post;
    }

}
