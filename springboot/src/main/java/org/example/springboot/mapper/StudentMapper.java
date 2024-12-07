package org.example.springboot.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.springboot.entity.Student;
import org.example.springboot.entity.Teacher;

public interface StudentMapper {

    void updateById(Student student);

    @Select("select * from students where id=#{id}")
    Student selectById(int id);


    @Select("select *from students where username=#{username}")
    Student selectByname(String username);
}
