package com.czxy.service;

import com.czxy.dao.CaritemMapper;
import com.czxy.dao.OrderitemMapper;
import com.czxy.domain.Caritem;
import com.czxy.domain.Orderitem;
import com.czxy.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Gongli
 * @version 1.0
 * @date 2019/8/2
 */
@Service
public class OrderitemService {
    @Autowired
    private OrderitemMapper orderitemMapper;

    @Autowired
    private CaritemService caritemService;


    @Autowired
    private CaritemMapper caritemMapper;

    @Autowired
    private ProductService productService;

    public void add(Orderitem orderitem) {
        System.out.println(orderitem);
    orderitemMapper.add(orderitem);
    }

    public Orderitem findorderTime(String format) {
        Orderitem orderitem = orderitemMapper.findOrderitem(format);
        return orderitem;
    }

    public void   orderall(Integer id) {
        List<Caritem> caritemList = caritemMapper.findall(id);
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String format = df.format(new Date().getTime());
        for (Caritem caritem : caritemList) {
            Product product = productService.findPro(caritem.getProid());
            Orderitem orderitem=new Orderitem(id,product.getName(),Double.parseDouble(product.getPrice()),caritem.getNumber(),"未支付",format);
            orderitemMapper.add(orderitem);
        }
        caritemMapper.Cleanall(id);

    }

    public List<Orderitem> findall(Integer id){

        List<Orderitem> findall = orderitemMapper.findall(id);
        return findall;
    }
}
