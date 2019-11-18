package com.courses.controller;

import com.courses.model.Answer;
import com.courses.dao.AnswersDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswersController {
    private AnswersDAO answersDAO;

    @Autowired
    public AnswersController(AnswersDAO answersDAO) {
        this.answersDAO = answersDAO;
    }

    @GetMapping("/api/answer/{id}")
    public Answer getAnswer(@PathVariable Long id){
        return answersDAO.findById(id).get();
    }

    @GetMapping(value = "/api/answer", produces = "application/json")
    public List<Answer> getAnswers (){
        return answersDAO.findAll();
    }

    @PostMapping(value = "/api/answer", consumes = "application/json", produces = "application/json")
    public Answer addAnswer(@RequestBody Answer answer){
        answersDAO.save(answer);
        return answer;
    }

    @PatchMapping(value = "/api/answer/{id}", consumes = "application/json", produces = "application/json")
    public Answer updateAnswer(@PathVariable Long id, @RequestBody Answer newAnswer){
        Answer answerFromDb = answersDAO.findById(id).get();
        if (answerFromDb != null){
            answerFromDb = answersDAO.findById(id).get();
            BeanUtils.copyProperties(newAnswer, answerFromDb);
            answersDAO.save(answerFromDb);
            return answerFromDb;
        }
        return null;
    }

    @DeleteMapping(value = "/api/answer/{id}", consumes = "application/json", produces = "application/json")
    public void deleteAnswer(@PathVariable Long id){
        answersDAO.deleteById(id);
    }

}

