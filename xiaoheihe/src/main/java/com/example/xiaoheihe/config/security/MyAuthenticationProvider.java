package com.example.xiaoheihe.config.security;

import com.example.xiaoheihe.domain.LoginUser;
import com.example.xiaoheihe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.LinkedList;
import java.util.List;

//2 authenticate
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Principal 主体，一般指用户名
        String userName = (String) authentication.getPrincipal();
        //Credentials 网络凭证,一般指密码
        String passWord = (String) authentication.getCredentials();
        //通过账号去数据库查询用户以及用户拥有的角色信息
        UserDetails details = userDetailsService.loadUserByUsername(userName);
        if (ObjectUtils.isEmpty(details)) {
            throw new AuthenticationServiceException("账号或密码错误！");
        }
        LoginUser userDetails = (LoginUser) details;
        //数据库密码
        String encodedPassword = userDetails.getPassword();

        if (!passwordEncoder.matches(encodedPassword, passWord)) {
            throw new AuthenticationServiceException("账号或密码错误！");
        }
        List<GrantedAuthority> roles = new LinkedList<>();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, passWord, roles);
        //这里可以放用户的详细信息
        token.setDetails(userDetails);
        return token;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
