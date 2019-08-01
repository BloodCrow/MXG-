package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;


    @PostMapping("reg")
    public ResponseEntity<Boolean>register(User user){
        System.out.println(user);

        if (user.getUsername().contentEquals( " ") || user.getUsername().equals("请输入用户名")){
            return new ResponseEntity<>(false,HttpStatus.OK);
        }

        User register = userService.register(user);
        if (register==null){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(false,HttpStatus.OK);
        }
    }


    @PostMapping
    public ResponseEntity<Boolean>login(User user, HttpSession session){
        User register = userService.login(user);
        if (register==null){
            return new ResponseEntity<>(false, HttpStatus.OK);
        }else {
            session.setAttribute("user",register);

            return new ResponseEntity<>(true,HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<Void>login( HttpSession session) {
        session.removeAttribute("user");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
