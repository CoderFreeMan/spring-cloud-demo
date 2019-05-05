package com.xwd.spring.cloud.demo.order.service.order;

import com.xwd.spring.cloud.demo.entity.order.OrderEntity;

/**
 * IOrderService
 *
 * @author: Kang
 * @time: 2018年03月30日 10:39
 */
public interface IOrderService {

    /**
     * query order by id
     *
     * @param orderId
     * @return
     */
    OrderEntity queryOrderById(String orderId);
}
