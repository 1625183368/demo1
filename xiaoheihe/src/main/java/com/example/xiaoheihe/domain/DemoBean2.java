//package com.example.xiaoheihe.domain;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.BeanNameAware;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
////@Component
//public class DemoBean2 implements BeanPostProcessor {
//    private final Map<String, Long> stats = new HashMap<>();
//    private final List<ExplainBean> explainBeans = new ArrayList<>();
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        stats.put(beanName,System.currentTimeMillis());
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        Long start = stats.get(beanName);
//        if (start!=null){
//            explainBeans.add(new ExplainBean(beanName,Math.toIntExact(System.currentTimeMillis()-start)));
//        }
//        return bean;
//    }
//
//    public List<ExplainBean> getExplainBeans(){
//        return explainBeans;
//    }
//}
