package com.xwd.spring.cloud.demo.entity.login;

import com.xwd.spring.cloud.demo.base.BaseEntity;

/**
 * LoginEntity
 *
 * @author: Kang
 * @time: 2018年03月29日 17:04
 */
public class LoginEntity extends BaseEntity {

    private static final long serialVersionUID = 3367498590504924482L;

    private String userId;

    private String loginId;

    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "userId='" + userId + '\'' +
                ", loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
