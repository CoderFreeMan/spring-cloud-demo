package com.xwd.spring.cloud.demo.user.web;

import com.xwd.spring.cloud.demo.base.BaseController;
import com.xwd.spring.cloud.demo.entity.user.UserEntity;
import com.xwd.spring.cloud.demo.user.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * UserController
 *
 * @author: Kang
 * @time: 2018年03月29日 17:47
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired private IUserService userService;

    @Value("${demo.redis.session.host}") private String host;
    @Value("${demo.redis.session.password}") private String password;

    /**
     * query user by id
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/queryUserById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserEntity queryUserById(String userId) {
        UserEntity userEntity = userService.queryUserById(userId);
        logger.info("query user by id, user: {}", userEntity);
        return userEntity;
    }

    /**
     * test config params
     *
     * @return
     */
    @RequestMapping(value = "/config", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String config(HttpSession session) {
        logger.debug("test config center string: {}, {}", host, password);
        logger.error("==============================================test logger level error");
        logger.info("=============================================={}", session.getId());
        logger.error("==============================================test logger level error");
        return host + "    " + password;
    }
}
