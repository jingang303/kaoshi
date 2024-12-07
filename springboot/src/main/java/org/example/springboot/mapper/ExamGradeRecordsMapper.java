package org.example.springboot.mapper;

import org.example.springboot.entity.Course;
import org.example.springboot.entity.ExamGradeRecords;
import org.example.springboot.entity.UserAccount;

import java.util.List;

public interface ExamGradeRecordsMapper {

    void add(ExamGradeRecords examGradeRecords);

    List<ExamGradeRecords> selectAll();

    ExamGradeRecords selectByStudentId(Integer studentId);

    List<ExamGradeRecords> selectByStudentIdAndCourseId( Integer studentId, Integer courseId);
}
