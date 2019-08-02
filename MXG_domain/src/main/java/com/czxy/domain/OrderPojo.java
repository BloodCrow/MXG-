package com.czxy.domain;

import java.util.List;

/**
 * @author Gongli
 * @version 1.0
 * @date 2019/8/2
 */
public class OrderPojo {
    private List<Orderitem> orderall;
    private User user;

    @Override
    public String toString() {
        return "OrderPojo{" +
                "orderall=" + orderall +
                ", user=" + user +
                '}';
    }

    public List<Orderitem> getOrderall() {
        return orderall;
    }

    public void setOrderall(List<Orderitem> orderall) {
        this.orderall = orderall;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderPojo() {
    }

    public OrderPojo(List<Orderitem> orderall, User user) {
        this.orderall = orderall;
        this.user = user;
    }
}
