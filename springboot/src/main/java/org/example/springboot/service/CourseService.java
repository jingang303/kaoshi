package org.example.springboot.service;

import org.example.springboot.entity.Course;
import org.example.springboot.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    public List<Course> selectCourseByTeacherUsername(String username) {
        return courseMapper.selectCourseByTeacherUsername();
    }


    public List<Course> selectCourse() {
        return courseMapper.selectCourse();
    }

    public List<Course> selectCourseByStudentName(String username) {
        return courseMapper.selectCourseByStudentName();
    }
}
