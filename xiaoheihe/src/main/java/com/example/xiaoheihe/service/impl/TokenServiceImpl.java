package com.example.xiaoheihe.service.impl;

import com.example.xiaoheihe.domain.LoginUser;
import com.example.xiaoheihe.service.TokenService;
import com.example.xiaoheihe.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisUtils redisUtils;


    public LoginUser getLoginUser(HttpServletRequest request, HttpServletResponse response){
        String headerToken = request.getHeader("x-token");
        if (StringUtils.isEmpty(headerToken)){
            //token为空则匹配账号密码后生成token
            getToken();
        }else {
            //token不为空则去redis里面取token

        }
        return null;
    }



    public String getToken(){
        return null;
    }
}
