package com.tutor.tutorbe.util;

import org.springframework.context.ApplicationContext;

public class SpringContext {
    public static ApplicationContext applicationContext;

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

}
