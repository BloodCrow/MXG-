package com.czxy.controller;

import com.czxy.domain.Product;
import com.czxy.domain.User;
import com.czxy.domain.UserPojo;
import com.czxy.domain.Userpojotwo;
import com.czxy.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("pr")
public class ProductController {
    @Resource
    private ProductService productService;
    @GetMapping
    public ResponseEntity<UserPojo> findAlPr(HttpSession session){
        UserPojo userPojo=new UserPojo();
        try {
            List<Product> allPr = productService.findAllPr();
            userPojo.setList(allPr);
            User user = (User) session.getAttribute("user");
            userPojo.setUser(user);
            return new ResponseEntity<>(userPojo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Userpojotwo> findPro(@PathVariable("id") String id,HttpSession session) {
        Product product = productService.findPro(Integer.parseInt(id));
        User user = (User) session.getAttribute("user");
        Userpojotwo userpojotwo=new Userpojotwo(product,user);
        return new ResponseEntity<>(userpojotwo,HttpStatus.OK);
    }



}
