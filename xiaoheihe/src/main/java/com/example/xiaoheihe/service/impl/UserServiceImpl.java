package com.example.xiaoheihe.service.impl;

import com.example.xiaoheihe.dao.UserMapper;
import com.example.xiaoheihe.domain.LoginUser;
import com.example.xiaoheihe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

//3 loadUserByUsername

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //加载用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)){
            return null;
        }
        LoginUser temp = new LoginUser();
        temp.setUsername(username);
        List<LoginUser> loginUsers = userMapper.selectUserList(temp);
        if (!CollectionUtils.isEmpty(loginUsers)){
            LoginUser loginUser = loginUsers.get(0);
//            List<SimpleGrantedAuthority> authorities  = new ArrayList<>();
//            //角色
//            authorities.add(new SimpleGrantedAuthority("USER"));
            return loginUser;
        }
        return null;
    }
}
