package org.example.springboot.service;

import jakarta.annotation.Resource;
import org.example.springboot.entity.Course;
import org.example.springboot.entity.ExamGradeRecords;
import org.example.springboot.mapper.CourseMapper;
import org.example.springboot.mapper.ExamGradeRecordsMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class ExamGradeRecordsService {
    @Resource
    private ExamGradeRecordsMapper examGradeRecordsMapper;

    public List<ExamGradeRecords> selectAll() {
        return examGradeRecordsMapper.selectAll();
    }
    public void add(ExamGradeRecords examGradeRecords) {
        examGradeRecords.setExamTime(String.valueOf(new Date()));
        examGradeRecordsMapper.add(examGradeRecords);
    }

    public ExamGradeRecords selectByStudentId(Integer studentId) {
        return examGradeRecordsMapper.selectByStudentId(studentId);
    }

    public List<ExamGradeRecords> selectByStudentIdAndCourseId( Integer studentId, Integer courseId) {
        return examGradeRecordsMapper.selectByStudentIdAndCourseId(studentId, courseId);
    }
}
