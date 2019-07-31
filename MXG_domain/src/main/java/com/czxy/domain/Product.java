package com.czxy.domain;

import javax.persistence.Id;
import javax.persistence.Table;
//CREATE TABLE `product` (
//  `id` INT(11) NOT NULL AUTO_INCREMENT, # 商品ip
//  `pid` INT(11) NOT NULL, # 商品类型 id
//  `name` VARCHAR(80) DEFAULT NULL, # 商品名
//  `tips` VARCHAR(200) DEFAULT NULL, # 简介
//  `price` VARCHAR(20) DEFAULT NULL, # 价格
//  `person` VARCHAR(50) DEFAULT NULL, # 提醒人数
//  `img` VARCHAR(50) DEFAULT NULL, # 图片
//  PRIMARY KEY (`id`)
//) ENGINE=INNODB DEFAULT CHARSET=utf8;
@Table(name = "product")
public class Product {

    @Id
    private Integer id; // 商品id
    private Integer pid;//商品类型id
    private String name;//商品名
    private String tips;//简介
    private String price;//价格
    private String person;//提醒人数
    private String img;//图片

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", tips='" + tips + '\'' +
                ", price='" + price + '\'' +
                ", person='" + person + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public Product(Integer id, Integer pid, String name, String tips, String price, String person, String img) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.tips = tips;
        this.price = price;
        this.person = person;
        this.img = img;
    }
}
