package com.xwd.spring.cloud.demo.base;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * BaseEntity
 *
 * @author: Kang
 * @time: 2018年03月29日 16:57
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 7675560183327230753L;

    private static final Logger logger = LoggerFactory.getLogger(BaseEntity.class);

    /**
     * over ride object toString
     *
     * @return
     */
    @Override
    public String toString() {
        try {
            return BeanUtils.describe(this).toString();
        } catch (Exception e) {
            logger.info("BaseBeanVo to String is failed...", e.getMessage());
        }
        return ToStringBuilder.reflectionToString(this);
    }
}
