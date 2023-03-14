package com.example.xiaoheihe;


import com.example.xiaoheihe.config.security.RsaKeyProperties;
import com.example.xiaoheihe.domain.DemoBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.example.**.dao")
@EnableAspectJAutoProxy
@ServletComponentScan()
@EnableConfigurationProperties(RsaKeyProperties.class)
public class Application {

    public static void main(String[] args) {
        //spring容器初始化

        SpringApplication.run(Application.class,args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
