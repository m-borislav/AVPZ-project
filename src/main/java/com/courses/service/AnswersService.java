package com.courses.service;

import com.courses.model.Answer;
import com.courses.dao.AnswersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class AnswersService{

    @Autowired
    private AnswersDAO answersDAO;

    public Optional<Answer> findById(Long id) {
        return answersDAO.findById(id);
    }
    public List<Answer> findAll() {
        return answersDAO.findAll();
    }

    public Answer save(Answer answer) {
        return answersDAO.save(answer);
    }

    public void deleteById(Long id) {
        answersDAO.deleteById(id);
    }

    public void deleteAll() {
        answersDAO.deleteAll();
    }
}
