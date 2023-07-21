package com.example.xiaoheihe.domain;

import lombok.SneakyThrows;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DemoBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,InitializingBean,BeanDefinitionRegistryPostProcessor, BeanPostProcessor,DisposableBean,FactoryBean {
    private final Map<String, Long> stats = new HashMap<>();
    private final List<ExplainBean> explainBeans = new ArrayList<>();

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware: " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.out.println("BeanFactoryAware: " + beanFactory.containsBean(name));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    //InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
//        Thread.sleep(5000);
        System.out.println("afterPropertiesSet");
    }

    //BeanFactoryPostProcessor
    @SneakyThrows
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("BeanFactoryPostProcessor1");
//        System.out.println("BeanFactoryPostProcessor1: " +registry.containsBeanDefinition(name));
    }

    //BeanFactoryPostProcessor
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor2");
//        System.out.println("BeanFactoryPostProcessor: " + beanFactory.containsBean(name));
    }
    //BeanPostProcessor
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "---加载中");
        stats.put(beanName,System.currentTimeMillis());
        return bean;
    }
    //BeanPostProcessor
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "---加载完成");
        Long start = stats.get(beanName);
        if (start!=null){
            explainBeans.add(new ExplainBean(beanName,Math.toIntExact(System.currentTimeMillis()-start)));
        }
        return bean;
    }

    //FactoryBean
    @Override
    public Object getObject() {
        System.out.println("FactoryBean");
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
    //DisposableBean
    @Override
    public void destroy() throws Exception {
//        System.out.println(name + "---卸载完成");
    }

    public List<ExplainBean> getExplainBeans(){
        explainBeans.sort((o1, o2) -> {
            try {
                //正数降序 负数升序 if o1.time < o2.time  return 1
                return o2.getLoadTime() - o1.getLoadTime();
            }catch (Exception e){
                return 0;
            }
        });
        return UnmodifiableList.unmodifiableList(explainBeans); //只读的集合
    }


}
