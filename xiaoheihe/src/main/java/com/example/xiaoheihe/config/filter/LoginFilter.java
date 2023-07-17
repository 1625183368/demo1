package com.example.xiaoheihe.config.filter;

import com.example.xiaoheihe.config.security.LoginFailuer;
import com.example.xiaoheihe.config.security.LoginSuccess;
import com.example.xiaoheihe.config.security.MyAuthenticationProvider;
import com.example.xiaoheihe.config.security.RsaKeyProperties;
import com.example.xiaoheihe.domain.LoginUser;
import com.example.xiaoheihe.utils.JWTUtils;
import com.example.xiaoheihe.utils.RedisUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//1 attemptAuthentication
@Component
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    @Autowired
    private MyAuthenticationProvider authenticationManager;
    @Autowired
    private RsaKeyProperties rsaKeyProperties;
    @Autowired
    LoginSuccess loginSuccessHandler;
    @Autowired
    LoginFailuer loginFailuerHandler;
    @Autowired
    private RedisUtils redisUtils;



    public LoginFilter() {
        //设置认证管理器(对登录请求进行认证和授权)
//        this.authenticationManager = authenticationManager;
//        this.rsaKeyProperties = rsaKeyProperties;
//        this.setAuthenticationSuccessHandler(loginSuccessHandler);
//        this.setAuthenticationFailureHandler(loginFailuerHandler);
        super.setFilterProcessesUrl("/login");
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginUser loginUser = new ObjectMapper().readValue(request.getInputStream(), LoginUser.class);

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUser.getUsername(),loginUser.getPassword());
//            usernamePasswordAuthenticationToken.setDetails(放用户信息);
            return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        }catch (Exception e){
            try {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
                Map<String,Object> resultMap = new HashMap<String,Object>(){
                    {
                        put("code", HttpServletResponse.SC_UNAUTHORIZED);
                        put("msg", "用户名或密码错误！");
                    }
                };
                out.write(new ObjectMapper().writeValueAsString(resultMap));
                out.flush();
                out.close();

            }catch (Exception outEx){
                outEx.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }

    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        LoginUser user = new LoginUser();
        user.setUsername(authResult.getName());
//        user.setRoles((List<RolePojo>)authResult.getAuthorities());
        //生成token
        String token = JWTUtils.generateTokenExpireInMinutes(user, rsaKeyProperties.getPrivateKey(), 24 * 60);
        //todo 将token放入redis
        redisUtils.set(redisUtils.getTokenPrefix()+token,user,redisUtils.getTimeOut(),redisUtils.getTimeUnit());

        response.addHeader("Authorization", "Bearer "+ token);
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            Map<String,Object> resultMap = new HashMap<String,Object>(){
                {
                    put("code", HttpServletResponse.SC_OK);
                    put("msg", "认证通过！");
                    put("token",token);
                }
            };

            out.write(new ObjectMapper().writeValueAsString(resultMap));
            out.flush();
            out.close();
        }catch (Exception outEx){
            outEx.printStackTrace();
        }
    }

    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

}
