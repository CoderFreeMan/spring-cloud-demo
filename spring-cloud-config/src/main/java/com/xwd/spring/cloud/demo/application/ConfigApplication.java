package com.xwd.spring.cloud.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <BR>ConfigApplication
 *
 * @author: Kang
 * @time: 2018年03月29日 15:10
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
//@EnableRedisHttpSession
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
