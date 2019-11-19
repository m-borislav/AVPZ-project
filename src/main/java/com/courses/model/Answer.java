package com.courses.model;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public
class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "text", nullable = false, length = 300)
    private String text;
    @Column(name = "correctAnswer", nullable = false, length = 5)
    private boolean correctAnswer;
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

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}