package com.example.xiaoheihe.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class LoginUser implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer loginFailedTimes;

    @JsonIgnore
    public List<? extends GrantedAuthority> getAuthorities(){
        List<SimpleGrantedAuthority> auth = new ArrayList<>();
        //模拟角色admin
        auth.add(new SimpleGrantedAuthority("ADMIN"));
        return auth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLoginFailedTimes() {
        return loginFailedTimes;
    }

    public void setLoginFailedTimes(Integer loginFailedTimes) {
        this.loginFailedTimes = loginFailedTimes;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
