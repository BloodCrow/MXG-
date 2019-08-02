package com.czxy.controller;

import com.czxy.domain.*;
import com.czxy.service.CaritemService;
import com.czxy.service.OrderitemService;
import com.czxy.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Gongli
 * @version 1.0
 * @date 2019/8/2
 */
@RestController
@RequestMapping("/order")
public class OrderitemController {
    @Resource
    private ProductService productService;

    @Resource
    private OrderitemService orderitemService;


    @GetMapping("/{id}")
    public ResponseEntity<OrderPojotwo> order(@PathVariable("id") String id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Product product = productService.findPro(Integer.parseInt(id));
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String format = df.format(new Date().getTime());
        Orderitem orderitem=new Orderitem(user.getId(),product.getName(),Double.parseDouble(product.getPrice()),1,"未支付",format);
        orderitemService.add(orderitem);
        Orderitem time = orderitemService.findorderTime(format);
        OrderPojotwo orderPojotwo=new OrderPojotwo(time,user);
        return new ResponseEntity<>(orderPojotwo,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<OrderPojo> listcar(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<Orderitem> orderall = orderitemService.findall(user.getId());
        OrderPojo orderPojo=new OrderPojo(orderall,user);
        return new ResponseEntity<>(orderPojo,HttpStatus.OK);
    }


    @DeleteMapping
    public ResponseEntity<Void> delorder(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
       orderitemService.orderall(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deloid(@PathVariable("id")String id){
        orderitemService.deloid(Integer.parseInt(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
