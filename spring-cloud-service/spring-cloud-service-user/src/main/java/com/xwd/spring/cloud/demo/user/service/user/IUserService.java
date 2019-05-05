package com.xwd.spring.cloud.demo.user.service.user;

import com.xwd.spring.cloud.demo.entity.user.UserEntity;

import java.util.List;

/**
 * IUserService
 *
 * @author: Kang
 * @time: 2018年03月29日 16:49
 */
public interface IUserService {

    /**
     * query user by id
     *
     *
     * @param userId
     * @return
     */
    UserEntity queryUserById(String userId);
}
