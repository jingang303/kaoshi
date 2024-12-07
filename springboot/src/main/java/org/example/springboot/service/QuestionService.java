package org.example.springboot.service;

import jakarta.annotation.Resource;
import org.example.springboot.entity.Question;
import org.example.springboot.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//这里取决于这个输入的题目的格式，我默认不需要前端每次再设置是哪个老师？或者哪个课程？但是好像不太会
public class QuestionService {
    @Resource
    private QuestionMapper questionMapper;
//    private Integer getCurrentTeacherId() {
//    }

    public void add(Question question) {
//        Integer currentTeacherId = getCurrentTeacherId();
//        question.setTeacherId(currentTeacherId);
        questionMapper.insert(question);
    }



    public void deleteById(Integer id) {
        questionMapper.deleteById(id);
    }

    public List<Question> selectAll() {
        return questionMapper.selectAll();
    }

    public void updateById(Question question) {
        questionMapper.updateById(question);
    }
}
