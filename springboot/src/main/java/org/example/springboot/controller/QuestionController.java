package org.example.springboot.controller;

import jakarta.annotation.Resource;
import org.example.springboot.common.Result;
import org.example.springboot.entity.Question;
import org.example.springboot.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Resource
    private QuestionService questionService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Question question) {
        questionService.add(question);
        return Result.success();
    }

    /**
     * 修改
     */

    @PutMapping("/updateById/{id}")
    public Result updateById(@PathVariable Integer id,@RequestBody Question question) {
        question.setId(id);

       // Integer teacherId=questionService.getTeacherId(id);
       // question.setTeacherId(teacherId);
        questionService.updateById(question);
        return Result.success();
    }
    /**
     * 单个删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        questionService.deleteById(id);
        return Result.success();
    }
    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Question> list = questionService.selectAll();
        return Result.success(list);
    }
//    //应该要导包
//    /**
//     * 分页查询
//     */
//    @GetMapping("/selectPage")
//    public Result selectPage(Question question,
//                             @RequestParam(defaultValue = "1") Integer pageNum,
//                             @RequestParam(defaultValue = "10") Integer pageSize) {
//        PageInfo<Question> pageInfo = questionService.selectPage(question, pageNum, pageSize);
//        return Result.success(pageInfo);
//    }





}
