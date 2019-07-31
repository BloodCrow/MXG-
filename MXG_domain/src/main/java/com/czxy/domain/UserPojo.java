package com.czxy.domain;

import java.util.List;

/**
 * @author Gongli
 * @version 1.0
 * @date 2019/7/29
 */
public class UserPojo {
        private List<Product> list;
        private User user;

    @Override
    public String toString() {
        return "UserPojo{" +
                "list=" + list +
                ", user=" + user +
                '}';
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserPojo() {
    }

    public UserPojo(List<Product> list, User user) {
        this.list = list;
        this.user = user;
    }
}
