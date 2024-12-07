package org.example.springboot.controller;
import jakarta.annotation.Resource;
import org.example.springboot.common.Result;
import org.example.springboot.entity.Teacher;
import org.example.springboot.service.TeacherService;
//import
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

        /*查询登录这个网站的教师的信息的接口
         *
         */
       @GetMapping("/select/{username}")
       public Result selectByUsername(@PathVariable String username) {
           Teacher teacher = teacherService.selectByUsername(username);
           return Result.success(teacher);
       }







}
