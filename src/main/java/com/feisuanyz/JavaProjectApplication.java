package com.feisuanyz;

import java.lang.Boolean;
import java.lang.String;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 项目启动类
 *
 * @author 95978
 * @date 2025-03-16 11:03:13
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
@MapperScan("com.feisuanyz.dao")
@ImportResource(locations = "classpath:datasource-config.xml")
public class JavaProjectApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(JavaProjectApplication.class);
        springApplication.setAllowCircularReferences(Boolean.TRUE);
        springApplication.run(args);
    }
}
