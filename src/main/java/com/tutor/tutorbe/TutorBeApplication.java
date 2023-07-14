package com.tutor.tutorbe;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.tutor.tutorbe.util.SpringContext;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TutorBeApplication implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(TutorBeApplication.class, args);
    }

    @Bean
    public Snowflake snowflake() {
        return IdUtil.getSnowflake();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.applicationContext = applicationContext;
    }

}
