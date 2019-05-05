package com.xwd.spring.cloud.demo.order.web;

import com.xwd.spring.cloud.demo.base.BaseController;
import com.xwd.spring.cloud.demo.entity.order.OrderEntity;
import com.xwd.spring.cloud.demo.order.service.order.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * OrderController
 *
 * @author: Kang
 * @time: 2018年03月30日 10:39
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired private IOrderService orderService;

    /**
     * 测试参数为实体
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/queryOrderById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public OrderEntity queryOrderById(@RequestBody OrderEntity params) {
        logger.debug("request params: [{}]", params);
        OrderEntity orderEntity = orderService.queryOrderById(params.getOrderId());
        logger.debug("query order data by id, order: {}", orderEntity);
        return orderEntity;
    }

    /**
     * 测试单个参数
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/testParamsString", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String testParamsString(@RequestBody String params) {
        logger.info("request params: [{}]", params);
        logger.info("request params: [{}]", params);
        return params;
    }

    /**
     * 测试单个参数
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/testParamsString1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String testParamsString1(@RequestBody Map<String, String> map) {
        logger.info("request params: [{}]", map);
        return String.valueOf(map);
    }
}
