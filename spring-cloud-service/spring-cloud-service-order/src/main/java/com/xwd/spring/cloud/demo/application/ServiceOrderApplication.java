package com.xwd.spring.cloud.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * <BR>ServiceApplication
 *
 * @author: Kang
 * @time: 2018年03月29日 15:47
 */
@SpringBootApplication
@ComponentScan({
        "com.xwd.spring.cloud.demo.order.web",
        "com.xwd.spring.cloud.demo.order.service"
})
@EnableEurekaClient
@EnableFeignClients("com.xwd.spring.cloud.demo.order.web")
public class ServiceOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }
}
