package org.example.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.springboot.entity.Teacher;

import java.util.List;

public interface TeacherMapper {

//    @Select("select name,gender,phone,employee_id,college,course from teachers where id=#{id}")
//    Teacher selectById(int id);
    //@Select("select name, gender, phone, employee_id, college, course from teachers where id = #{id}")
    Teacher selectById(Integer id);
    @Select("select name, gender, phone, employee_id, college, course from teachers where username=#{username}")
    Teacher selectByUsername(String username);
}