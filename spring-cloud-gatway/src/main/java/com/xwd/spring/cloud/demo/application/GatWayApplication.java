package com.xwd.spring.cloud.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * GatWayApplication 服务网关
 *
 * @author: Kang
 * @time: 2018年04月02日 8:26
 */
/*@ComponentScan({
        "com.xwd.spring.cloud.demo.filter"
})*/
@SpringBootApplication
@EnableEurekaClient
//@EnableZuulProxy
//@EnableRedisHttpSession
public class GatWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatWayApplication.class, args);
    }
}
