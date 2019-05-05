package com.xwd.spring.cloud.demo.order.service.order.impl;

import com.xwd.spring.cloud.demo.entity.order.OrderEntity;
import com.xwd.spring.cloud.demo.order.service.order.IOrderService;
import com.xwd.spring.cloud.demo.utils.DateUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * OrderServiceImpl
 *
 * @author: Kang
 * @time: 2018年03月30日 10:40
 */
@Component
public class OrderServiceImpl implements IOrderService {

    /**
     * query order by id
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderEntity queryOrderById(String orderId) {
        return generateOrder(1).get(0);
    }

    /**
     * 生成订单数据
     *
     * @param num
     * @return
     */
    private List<OrderEntity> generateOrder(int num) {
        List<OrderEntity> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setOrderId("orderId" + i);
            orderEntity.setOrderName("orderName" + i);

            String date = DateUtils.formatDateToString(new Date(), DateUtils.DATETIME_19);
            orderEntity.setCreateDate(date);

            list.add(orderEntity);
        }
        return list;
    }
}
