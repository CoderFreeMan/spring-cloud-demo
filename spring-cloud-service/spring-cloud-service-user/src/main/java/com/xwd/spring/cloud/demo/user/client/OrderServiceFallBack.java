package com.xwd.spring.cloud.demo.user.client;

import com.xwd.spring.cloud.demo.entity.order.OrderEntity;
import com.xwd.spring.cloud.demo.fallback.BaseFallBack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 熔断机制调用（降级）
 *
 * @author: Kang
 * @time: 2018年04月04日 10:57
 */
@Component
public class OrderServiceFallBack extends BaseFallBack implements OrderServiceFegin {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceFallBack.class);

    @Override
    public OrderEntity queryOrderById(OrderEntity orderEntity) {
        logger.info("===============================================1111111111111111111111111111111111111111");
        return orderEntity;
    }

    @Override
    public String testParamsString(String params) {
        logger.info("===============================================2222222222222222222222222222222");
        return "[222222222222222222222222222222222222]";
    }

    @Override
    public String testParamsString1(Map<String, String> map) {
        logger.info("===============================================33333333333333333333333333333333333");
        return "[3333333333333333333333333333333333333333333]";
    }
}
