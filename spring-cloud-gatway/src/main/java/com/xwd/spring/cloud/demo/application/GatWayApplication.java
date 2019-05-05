package com.xwd.spring.cloud.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * GatWayApplication 服务网关
 *
 * @author: Kang
 * @time: 2018年04月02日 8:26
 */
@SpringBootApplication
@ComponentScan({
        "com.xwd.spring.cloud.demo.filter"
})
@EnableEurekaClient
@EnableZuulProxy
//@EnableRedisHttpSession
public class GatWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatWayApplication.class, args);
    }
}
