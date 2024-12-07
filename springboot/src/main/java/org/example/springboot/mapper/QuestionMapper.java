package org.example.springboot.mapper;

import org.example.springboot.entity.Question;

import java.util.List;

public interface QuestionMapper {
    int insert(Question question);
    void deleteById(Integer id);
    void updateById(Question question);
    List<Question> selectAll();
}