package com.example.xiaoheihe.config.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DemoListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(DemoListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("初始化servlet");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("销毁servlet");
    }
}
