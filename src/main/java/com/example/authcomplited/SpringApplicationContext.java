package com.example.authcomplited;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware {
    private static ApplicationContext CONTEXT;

    public void setApplicationContext(ApplicationContext contex) throws BeansException {
        CONTEXT = contex;
    }

    public static Object getBean(String beanName) {
        return CONTEXT.getBean(beanName);
    }
}
