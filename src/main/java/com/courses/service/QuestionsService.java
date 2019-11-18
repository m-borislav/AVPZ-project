package com.courses.service;

import com.courses.model.Question;
import com.courses.dao.QuestionsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsDAO questionsDAO;


    public Question save(Question question) {
        return questionsDAO.save(question);
    }

    public List<Question> findAll() {
        return questionsDAO.findAll();
    }

    public Optional<Question> findById(Long id) {
        return findById(id);
    }

    public void deleteAll() {
        questionsDAO.deleteAll();
    }

    public void deleteById(Long id) {
        questionsDAO.deleteById(id);
    }

}
