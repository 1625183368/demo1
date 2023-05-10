package com.example.xiaoheihe.config.filter;

import com.example.xiaoheihe.config.security.RsaKeyProperties;
import com.example.xiaoheihe.domain.LoginUser;
import com.example.xiaoheihe.domain.Payload;
import com.example.xiaoheihe.utils.JWTUtils;
import com.example.xiaoheihe.utils.RedisUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//@Component
public class TokenVerifyFilter extends OncePerRequestFilter {
    @Autowired
    private RsaKeyProperties rsaKeyProperties;
    @Autowired
    private RedisUtils redisUtils;
    @Value("${spring.redis.login.token.prefix}")
    private String REDISLOGINTOKENPREFIX;

//    public TokenVerifyFilter(RsaKeyProperties rsaKeyProperties) {
////        super(authenticationManager);
//        this.rsaKeyProperties = rsaKeyProperties;
//    }
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            //如果携带错误的token，则给用户提示请登录！
            // chain.doFilter(request, response);
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            PrintWriter out = response.getWriter();
            Map<String,Object> resultMap = new HashMap<String,Object>(){
                {
                    put("code", HttpServletResponse.SC_FORBIDDEN);
                    put("msg", "请登录！");
                }
            };

            out.write(new ObjectMapper().writeValueAsString(resultMap));
            out.flush();
            out.close();
        } else {
            //如果携带了正确格式的token要先得到token
            String token = header.replace("Bearer ", "");
            //验证redis中的token
            LoginUser user = (LoginUser) redisUtils.get(redisUtils.getTokenPrefix() + token);
            if (!ObjectUtils.isEmpty(user)){
                //token续租
                redisUtils.expire(redisUtils.getTokenPrefix() + token,redisUtils.getTimeOut(), redisUtils.getTimeUnit());
                UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
                //******设置是否已认证
//                authResult.setAuthenticated(true);
                SecurityContextHolder.getContext().setAuthentication(authResult);
                chain.doFilter(request, response);
            }else {
                //验证token是否正确
                Payload<LoginUser> payload = JWTUtils.getInfoFromToken(token, rsaKeyProperties.getPublicKey(), LoginUser.class);
                user = payload.getUserInfo();
                if (user != null) {
                    redisUtils.set(redisUtils.getTokenPrefix()+token,user,redisUtils.getTimeOut(),redisUtils.getTimeUnit());

                    UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
                    //******设置是否已认证
//                authResult.setAuthenticated(true);
                    SecurityContextHolder.getContext().setAuthentication(authResult);
                    chain.doFilter(request, response);
                }
            }
        }
    }
}
