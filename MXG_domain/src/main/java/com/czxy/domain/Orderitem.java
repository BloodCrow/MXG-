package com.czxy.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DateFormat;

/**
 * @author Gongli
 * @version 1.0
 * @date 2019/8/2
 */
@Table(name = "order")
public class Orderitem {
    @Id
    private Integer oid;
    private Integer userid;
    private String pname;
    private Double price;
    private Integer number;
    private Double sumprice;
    private String orderStatus;
    private String orderTime;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getSumprice() {
       Double a=number*price;
        return a;
    }

    public void setSumprice(Double sumprice) {
        this.sumprice = sumprice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Orderitem() {
    }

    public Orderitem(Integer userid, String pname, Double price, Integer number, String orderStatus, String orderTime) {
        this.userid = userid;
        this.pname = pname;
        this.price = price;
        this.number = number;
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
    }
}