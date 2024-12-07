package org.example.springboot.controller;

import jakarta.annotation.Resource;
import org.example.springboot.common.Result;
import org.example.springboot.entity.ExamGradeRecords;
import org.example.springboot.service.ExamGradeRecordsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/exam_grade_records")
public class ExamGradeRecordsController {
    @Resource
    private ExamGradeRecordsService examGradeRecordsService;
    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody ExamGradeRecords examGradeRecords) {
        examGradeRecordsService.add(examGradeRecords);
        return Result.success();
    }
    /**
     * 单个查询
     */
    @GetMapping("/selectByStudentId/{StudentId}")
    public Result selectByStudentId(@PathVariable Integer StudentId) {
        ExamGradeRecords examGradeRecords = examGradeRecordsService.selectByStudentId(StudentId);
        return Result.success(examGradeRecords);
    }
    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<ExamGradeRecords> list = examGradeRecordsService.selectAll();
        return Result.success(list);
    }
    //先不写分页查询了，有时间再写

    @GetMapping("/selectAllGrades_of_the_student")
    public Result ByStudentIdAndCourseId(@RequestParam Integer studentId, @RequestParam Integer courseId) {
        List<ExamGradeRecords> list = examGradeRecordsService.selectByStudentIdAndCourseId(studentId,courseId);
        return Result.success(list);
    }
}
