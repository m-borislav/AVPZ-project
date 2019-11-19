package com.courses.model;

import javax.persistence.*;

@Entity
@Table(name = "UserLesson")
public class UserLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = User.class)
    private User user;
    @ManyToOne(targetEntity = Lesson.class)
    private Lesson lesson;

    public UserLesson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
