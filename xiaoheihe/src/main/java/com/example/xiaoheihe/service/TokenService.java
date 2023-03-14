package com.example.xiaoheihe.service;

import com.example.xiaoheihe.domain.LoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TokenService {
    LoginUser getLoginUser(HttpServletRequest request, HttpServletResponse response);
}
