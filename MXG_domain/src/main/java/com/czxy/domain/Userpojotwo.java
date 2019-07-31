package com.czxy.domain;

import java.util.List;

/**
 * @author Gongli
 * @version 1.0
 * @date 2019/7/31
 */
public class Userpojotwo {

    private Product product;
    private User user;

    @Override
    public String toString() {
        return "Userpojotwo{" +
                "product=" + product +
                ", user=" + user +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Userpojotwo() {
    }

    public Userpojotwo(Product product, User user) {
        this.product = product;
        this.user = user;
    }
}
