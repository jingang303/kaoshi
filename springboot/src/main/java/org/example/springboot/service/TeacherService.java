package org.example.springboot.service;

import jakarta.annotation.Resource;
import org.example.springboot.entity.Teacher;

import org.example.springboot.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService  {
    @Autowired
    private TeacherMapper teacherMapper;

    public Teacher selectById(int id) {
        return teacherMapper.selectById(id);
    }

    //通过用户名
    public Teacher selectByUsername(String username) {
        return teacherMapper.selectByUsername(username);
    }
}
