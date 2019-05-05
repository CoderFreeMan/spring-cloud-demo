package com.xwd.spring.cloud.demo.entity.order;

import com.xwd.spring.cloud.demo.base.BaseEntity;

/**
 * OrderEntity
 *
 * @author: Kang
 * @time: 2018年03月30日 10:42
 */
public class OrderEntity extends BaseEntity {

    private static final long serialVersionUID = -6531940862079090795L;

    private String orderId;

    private String orderName;

    private String createDate;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
