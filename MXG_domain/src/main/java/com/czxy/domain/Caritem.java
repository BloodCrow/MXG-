package com.czxy.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Gongli
 * @version 1.0
 * @date 2019/8/1
 */
@Table(name = "shoppingcart")
public class Caritem {
    private Integer upid;
    private Integer userid;
    private Integer proid;
    private Integer number;


    private Product product;
    private Double total;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getTotal() {
        Double a=Double.parseDouble(product.getPrice())*number;
        return a;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Caritem(Integer userid, Integer proid, Integer number) {
        this.userid = userid;
        this.proid = proid;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Caritem{" +
                "upid=" + upid +
                ", userid=" + userid +
                ", proid=" + proid +
                ", number=" + number +
                '}';
    }

    public Integer getUpid() {
        return upid;
    }

    public void setUpid(Integer upid) {
        this.upid = upid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Caritem() {
    }

    public Caritem(Integer upid, Integer userid, Integer proid, Integer number) {
        this.upid = upid;
        this.userid = userid;
        this.proid = proid;
        this.number = number;
    }


}
