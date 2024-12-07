package org.example.springboot.mapper;

import org.example.springboot.entity.Course;

import java.util.List;

public interface CourseMapper {



    List<Course> selectCourse();
    List<Course> selectCourseByTeacherUsername();
    List<Course> selectCourseByStudentName();
}
