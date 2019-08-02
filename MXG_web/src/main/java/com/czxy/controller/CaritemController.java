package com.czxy.controller;

import com.czxy.domain.CarPojp;
import com.czxy.domain.Caritem;
import com.czxy.domain.Product;
import com.czxy.domain.User;
import com.czxy.service.CaritemService;
import com.czxy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Gongli
 * @version 1.0
 * @date 2019/8/1
 */
@RestController
@RequestMapping("/Caritem")
public class CaritemController  {

    @Resource
    private ProductService productService;

    @Autowired
    private CaritemService caritemService;


    @GetMapping("/{id}")
    public ResponseEntity<Void> findPro(@PathVariable("id") String id, HttpSession session) {
        Product product = productService.findPro(Integer.parseInt(id));
        User user = (User) session.getAttribute("user");
        if (user==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Caritem caritem=new Caritem(user.getId(),product.getId(),1);
        Caritem caritem1 = caritemService.find(caritem);
        if (caritem1==null){
            caritemService.addcart(caritem);
        }else {
            caritem.setNumber(caritem1.getNumber()+1);
            caritemService.update(caritem);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CarPojp> findall( HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        CarPojp carPojp = caritemService.findall(user.getId(),user);
        return new ResponseEntity<>(carPojp,HttpStatus.OK);
    }

    @DeleteMapping("/{upid}")
    public ResponseEntity<Void> delcar(@PathVariable("upid")String upid){
        caritemService.del(Integer.parseInt(upid));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/Cleanall")
    public ResponseEntity<Void> Cleanall(HttpSession session){
        User user = (User) session.getAttribute("user");
        caritemService.Cleanall(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //加数量
    @GetMapping("AddNum")
    public ResponseEntity<Void>Addnum(String pid,HttpSession session){
        User user = (User) session.getAttribute("user");
        Caritem num = caritemService.num(user.getId(), Integer.parseInt(pid));
        num.setNumber(num.getNumber()+1);
        System.out.println(num);
        caritemService.update(num);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //减数量
    @GetMapping("decrease")
    public ResponseEntity<Void>decrease(String pid,HttpSession session){
        User user = (User) session.getAttribute("user");
        Caritem num = caritemService.num(user.getId(), Integer.parseInt(pid));
        num.setNumber(num.getNumber() - 1);
        if (num.getNumber()<=1) {
            num.setNumber(1);
        }

        caritemService.update(num);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
