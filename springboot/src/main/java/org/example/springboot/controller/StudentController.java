package org.example.springboot.controller;

import jakarta.annotation.Resource;
import org.example.springboot.common.Result;
import org.example.springboot.entity.Student;
import org.example.springboot.entity.Teacher;
import org.example.springboot.service.StudentService;
import org.example.springboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {
        @Autowired
        private StudentService studentService;

        /*查询并且呈现登录这个网站的学生的信息的接口
         *
         */
        @GetMapping("/select/{id}")
        public Result selectById(@PathVariable int id) {
            Student student = studentService.selectById(id);
            return Result.success(student);
        }
     /*修改
     *
     */
        @GetMapping("/updata")
        public Result updata(@RequestBody Student student) {
          studentService.updataById(student);
          return Result.success();
    }




    }
