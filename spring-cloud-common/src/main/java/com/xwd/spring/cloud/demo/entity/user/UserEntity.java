package com.xwd.spring.cloud.demo.entity.user;

import com.xwd.spring.cloud.demo.base.BaseEntity;

/**
 * UserEntity
 *
 * @author: Kang
 * @time: 2018年03月29日 17:04
 */
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = 3473279151091954033L;

    private String userId;

    private String userName;

    private Integer age;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
