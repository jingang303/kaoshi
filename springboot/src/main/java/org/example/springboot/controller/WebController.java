package org.example.springboot.controller;

import jakarta.annotation.Resource;
import org.example.springboot.common.Result;
import org.example.springboot.entity.UserAccount;
import org.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class WebController {
    @Autowired
    private UserService userService;
    @CrossOrigin
    @PostMapping("/login")
    public Result login(@RequestBody UserAccount user){
        UserAccount dbUser=userService.login(user);
        return Result.success(dbUser);
    }
//    //需要注册吗？
//    @CrossOrigin
//    @PostMapping("/register")
//    public Result register(@RequestBody UserAccount user){
//     //   userService.register(user);
//        return Result.success();
//    }



}

