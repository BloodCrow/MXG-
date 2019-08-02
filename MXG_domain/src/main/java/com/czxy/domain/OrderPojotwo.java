package com.czxy.domain;

/**
 * @author Gongli
 * @version 1.0
 * @date 2019/8/2
 */
public class OrderPojotwo {
    private Orderitem orderitem;
    private User user;

    @Override
    public String toString() {
        return "OrderPojotwo{" +
                "orderitem=" + orderitem +
                ", user=" + user +
                '}';
    }

    public Orderitem getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(Orderitem orderitem) {
        this.orderitem = orderitem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderPojotwo() {
    }

    public OrderPojotwo(Orderitem orderitem, User user) {
        this.orderitem = orderitem;
        this.user = user;
    }
}
