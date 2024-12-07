package org.example.springboot.controller;

import jakarta.annotation.Resource;
import org.example.springboot.common.Result;
import org.example.springboot.entity.Course;
import org.example.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    /**
     * 根据老师id呈现相应的课程信息
     */
    @GetMapping("/teacher_courses/{username}")
    public Result selectCourseByTeacherUsername(@PathVariable String username) {
        List<Course> list =courseService.selectCourseByTeacherUsername(username);
        return Result.success(list);
    }

    @GetMapping("/courses")
    public Result selectCourse() {
        List<Course> list =courseService.selectCourse();
        return Result.success(list);
    }
    /**
     * 根据学生名字呈现所选择课程信息
     */
    @GetMapping("/student_courses/{username}")
    public Result selectCourseByStudentName(@PathVariable String username) {
        List<Course> list =courseService.selectCourseByStudentName(username);
        return Result.success(list);
    }

}
