package com.czxy.domain;

import java.util.List;

/**
 * @author Gongli
 * @version 1.0
 * @date 2019/8/1
 */
public class CarPojp {

    private List<Caritem> list;
    private Double intotal;
    private User user;

    public CarPojp(List<Caritem> list, User user) {
        this.list = list;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CarPojp(List<Caritem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "CarPojp{" +
                "list=" + list +
                ", intotal=" + intotal +
                '}';
    }

    public List<Caritem> getList() {
        return list;
    }

    public void setList(List<Caritem> list) {
        this.list = list;
    }

    public Double getIntotal() {
        Double a=0.0;
        for (Caritem caritem : list) {
            a+=caritem.getTotal();
        }

        return a;
    }

    public void setIntotal(Double intotal) {
        this.intotal = intotal;
    }

    public CarPojp() {
    }

    public CarPojp(List<Caritem> list, Double intotal) {
        this.list = list;
        this.intotal = intotal;
    }
}
