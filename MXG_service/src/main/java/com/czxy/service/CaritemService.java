package com.czxy.service;

import com.czxy.dao.CaritemMapper;
import com.czxy.dao.ProductMapper;
import com.czxy.domain.CarPojp;
import com.czxy.domain.Caritem;
import com.czxy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gongli
 * @version 1.0
 * @date 2019/8/1
 */
@Service
public class CaritemService {
    @Autowired
    private CaritemMapper caritemMapper;

    @Autowired
    private ProductMapper productMapper;

    public void addcart(Caritem caritem) {
        caritemMapper.addCart(caritem);
    }

    public Caritem find(Caritem caritem) {
        Caritem caritem1 = caritemMapper.find(caritem);
        return caritem1;
    }

    public void update(Caritem caritem) {
        caritemMapper.update(caritem);
    }

    public CarPojp findall(Integer id, User user) {
        List<Caritem> findall = caritemMapper.findall(id);

        for (Caritem caritem : findall) {
            caritem.setProduct(productMapper.selectByPrimaryKey(caritem.getProid()));
            System.out.println(caritem);
        }

        return new CarPojp(findall,user);
    }
}