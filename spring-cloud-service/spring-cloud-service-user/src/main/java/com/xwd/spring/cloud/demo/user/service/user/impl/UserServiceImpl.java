package com.xwd.spring.cloud.demo.user.service.user.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xwd.spring.cloud.demo.entity.order.OrderEntity;
import com.xwd.spring.cloud.demo.entity.user.UserEntity;
import com.xwd.spring.cloud.demo.user.client.OrderServiceFegin;
import com.xwd.spring.cloud.demo.user.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserServiceImpl
 *
 * @author: Kang
 * @time: 2018年03月29日 16:49
 */
@Component
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final String URL_ORDER = "http://demo-service-order";

    @Qualifier("orderServiceFallBack")
    @Autowired private OrderServiceFegin orderServiceFegin;

    @Autowired private RestTemplate restTemplate;

    /**
     * query user by id
     *
     * @param userId
     * @return
     */
    @Override
    public UserEntity queryUserById(String userId) {
        testParamsString();

        testParamsString1();

        testRestTemplateClient();

        testFeginClient();

        return generateUser(1).get(0);
    }

    /**
     * generate user
     *
     * @param num
     * @return
     */
    private List<UserEntity> generateUser(int num) {
        List<UserEntity> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId("userId" + i);
            userEntity.setUserName("userName" + i);
            userEntity.setAge(20 + i);

            list.add(userEntity);
        }
        return list;
    }

    /**
     * 测试调用参数为 String
     */
    private void testParamsString() {
        try {
            String returnParams = orderServiceFegin.testParamsString("xxxxxxxxxx");
            logger.info("orderServiceFegin testParamsString return params: {}", returnParams);
        } catch (Exception e) {
            logger.error("request testParamsString fegin is error", e);
        }
    }
    /**
     * 测试调用参数为 String
     */
    private void testParamsString1() {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("userName", "xxxxxx");
            map.put("age", "20");
            String returnParams = orderServiceFegin.testParamsString1(map);
            logger.info("orderServiceFegin testParamsString1 return params: {}", returnParams);
        } catch (Exception e) {
            logger.error("request testParamsString1 fegin is error", e);
        }
    }

    /**
     * test fegin client
     */
    private void testFeginClient() {
        try {
            OrderEntity feginParams = new OrderEntity();
            feginParams.setOrderId("feginParamsOrderId");
            feginParams.setOrderName("feginParamsOrderName");
            OrderEntity orderEntity = orderServiceFegin.queryOrderById(feginParams);
            logger.info("fegin testFeginClient orderEntity ===>>> {}", orderEntity);
        } catch (Exception e) {
            logger.error("request testFeginClient fegin is error", e);
        }
    }

    /**
     * test rest template client
     */
//    @HystrixCommand(fallbackMethod = "testRestTemplateFallBack")  测试注解熔错机制未通过
    private void testRestTemplateClient() {
        try {
            Map params = new HashMap<>();
            params.put("orderId", "restTemplateOrderId");
            params.put("orderName", "restTemplateOrderName");
            OrderEntity orderEntity = restTemplate.postForObject(URL_ORDER + "/order/queryOrderById", params, OrderEntity.class);
            logger.info("restTemplate testRestTemplateClient orderEntity ===>>> {}", orderEntity);

        } catch (Exception e) {
            logger.error("request testRestTemplateClient restTemplate is error", e);
        }
    }

    public String testRestTemplateFallBack() {
        logger.info("===============================================444444444444444444444444444444444");
        return "[4444444444444444444444444444]";
    }
}
