package com.example.xiaoheihe.domain;

public class ExplainBean {
    String beanName;
    Integer loadTime;

    public ExplainBean(String beanName, Integer loadTime) {
        this.beanName = beanName;
        this.loadTime = loadTime;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Integer getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Integer loadTime) {
        this.loadTime = loadTime;
    }
}
