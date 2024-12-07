package org.example.springboot.service;

import jakarta.annotation.Resource;
import org.example.springboot.entity.Student;
import org.example.springboot.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;

@Service
public class StudentService {
   @Resource
    private StudentMapper studentMapper;

   public Student selectById(int id){
       return studentMapper.selectById(id);
   }

    public void updataById(Student student) {
        studentMapper.updateById(student);
    }
}
