package com.courses.service;

import com.courses.dao.QuestionsDAO;
import com.courses.model.Answer;
import com.courses.dao.AnswersDAO;
import com.courses.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Set;

public class AnswersService{

    @Autowired
    private QuestionsDAO questionsDAO;

    boolean chekAnswer(Set<Answer> answers, Question question){
        for (Answer answer : answers){
            Answer answerFromDb = questionsDAO.;
            if (){

            }
        }
    }
}
