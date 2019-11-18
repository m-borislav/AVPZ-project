package com.courses.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "answers")
//@Component
public
class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "text", unique = true, nullable = false, length = 300)
    private String text;
    @ManyToOne(targetEntity = Question.class)
    private Question question;

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}