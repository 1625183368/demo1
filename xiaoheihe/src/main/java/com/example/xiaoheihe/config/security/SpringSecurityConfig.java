package com.example.xiaoheihe.config.security;

import com.example.xiaoheihe.config.filter.LoginFilter;
import com.example.xiaoheihe.config.filter.TokenVerifyFilter;
import com.example.xiaoheihe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.w3c.dom.html.HTMLParagraphElement;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 核心为loginfilter和tokenfilter
     * */

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
//    @Autowired
//    private RsaKeyProperties rsaKeyProperties;
//    /**
//     * 未授权处理
//     * */
    @Autowired
    private SecurityResponseAuthenticationEntryPoint entryPoint;
    /**
     * 退出登陆处理
     * */
    @Autowired
    private LogoutSuccess logoutSuccessHandler;
//    /**
//     * 认证成功处理
//     * */
//    @Autowired
//    private LoginSuccess loginSuccessHandler;
//    /**
//     * 认证失败处理
//     * */
//    @Autowired
//    private LoginFailuer loginFailuerHandler;
//
//    @Autowired
//    private MyAuthenticationProvider provider;
    /**
     * token认证
     * */
    @Autowired
    private TokenVerifyFilter tokenVerifyFilter;

    @Autowired
    private LoginFilter loginFilter;

    @Value("securityUrlConfig.ignoreUrl")
    private String ignoreUrl;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    /**
     * 先通过内存中的账号密码来处理
     * @param auth
     * @throws Exception
     */
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("admin")
//                .roles("USER");
//
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }



    public void configure(HttpSecurity http) throws Exception {
        String[] ignoreURLs = ignoreUrl.split(",");

//        http.exceptionHandling().authenticationEntryPoint(entryPoint)
//                .and()
//                .authorizeRequests()
//                .antMatchers(ignoreURLs)
//                .permitAll()
//                .antMatchers("/**").hasAnyRole("USER")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
////                .loginPage("/login.jsp")
//                .loginProcessingUrl("/login")
//                .successForwardUrl("/welcome")
////                .failureForwardUrl("/failure.jsp")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .invalidateHttpSession(true)
////                .logoutSuccessUrl("/login.jsp")
//                .permitAll()
//                .and()
//                .csrf()
//                .disable();
        http.csrf()
                .disable()
                //认证失败处理
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .authorizeRequests()
                //匿名访问 不允许登陆后访问
                .antMatchers("/login","/captchaImage").anonymous()
                .antMatchers(HttpMethod.GET,ignoreURLs).permitAll()
                //其他的需要鉴权
                .anyRequest()
                .authenticated()
                .and()
                //token认证
                .addFilterAfter(tokenVerifyFilter, UsernamePasswordAuthenticationFilter.class)
                //登陆认证
                .addFilter(loginFilter)
                //基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll();
    }



}