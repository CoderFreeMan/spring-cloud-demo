package com.xwd.spring.cloud.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * service user application
 */
@SpringBootApplication
@ComponentScan({
        "com.xwd.spring.cloud.demo.user.web",
        "com.xwd.spring.cloud.demo.user.service",
        "com.xwd.spring.cloud.demo.user.client"
})
@EnableEurekaClient
@EnableFeignClients("com.xwd.spring.cloud.demo.user.client")
//@EnableCircuitBreaker //开启断路器功能，进行容错管理      测试注解熔错机制未通过
//@EnableRedisHttpSession
public class ServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
