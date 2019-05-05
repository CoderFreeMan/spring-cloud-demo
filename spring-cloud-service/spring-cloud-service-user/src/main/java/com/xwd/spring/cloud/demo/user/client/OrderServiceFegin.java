package com.xwd.spring.cloud.demo.user.client;

import com.xwd.spring.cloud.demo.entity.order.OrderEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * OrderServiceFegin
 *
 * @author: Kang
 * @time: 2018年04月03日 13:17
 */
@FeignClient(value = "demo-service-order", fallback = OrderServiceFallBack.class)
public interface OrderServiceFegin {

    @RequestMapping(value = "/order/queryOrderById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    OrderEntity queryOrderById(OrderEntity orderEntity);

    @RequestMapping(value = "/order/testParamsString", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String testParamsString(String params);

    @RequestMapping(value = "/order/testParamsString1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String testParamsString1(Map<String, String> map);
}
