package com.example.xiaoheihe.config.aop;


import com.example.xiaoheihe.config.DynamicDataSource;
import com.example.xiaoheihe.config.annotation.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Aspect
@Component
public class TargetDataSourceAspect {
    @Pointcut("@annotation(com.example.xiaoheihe.config.annotation.DataSource)||@within(com.example.xiaoheihe.config.annotation.DataSource)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        DataSource dataSource = signature.getMethod().getAnnotation(DataSource.class);
        Assert.notNull(dataSource,"未找到数据源");

        try {
            //切换数据源
            DynamicDataSource.setDataSourceType(dataSource.value().name());
            return joinPoint.proceed();
        }finally {
            //sql执行之后清空数据源还原默认
            DynamicDataSource.clearDataSourceType();
        }
    }
}
