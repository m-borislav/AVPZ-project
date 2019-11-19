package com.courses.controller;

import com.courses.model.Question;
import com.courses.dao.QuestionsDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionsController{
    private QuestionsDAO questionsDAO;

    @Autowired
    public QuestionsController(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    @GetMapping("/api/question/{id}")
    public Question getQuestion(@PathVariable Long id){
        return questionsDAO.findById(id).get();
    }

    @PostMapping(value = "/api/question", consumes = "application/json", produces = "application/json")
    public Question addQuestion(@RequestBody Question question){
        questionsDAO.save(question);
        return question;
    }

    @DeleteMapping(value = "/api/question/{id}", consumes = "application/json", produces = "application/json")
    public Question deleteQuestion(@PathVariable Long id){
        questionsDAO.deleteById(id);
        return null;
    }

    @PatchMapping(value = "/api/question/{id}", consumes = "application/json", produces = "application/json")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question newQuestion){
        Question questionFromDb = questionsDAO.findById(id).get();
        if (questionFromDb != null){
            questionFromDb = questionsDAO.findById(id).get();
            BeanUtils.copyProperties(newQuestion, questionFromDb);
            questionsDAO.save(questionFromDb);
            return questionFromDb;
        }
        return null;
    }

}
