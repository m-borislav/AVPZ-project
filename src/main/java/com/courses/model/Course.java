package com.courses.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "courseName", nullable = false, unique = true, length = 100)
    private String courseName;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Lesson> lesson;
    @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;


    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<Lesson> getLesson() {
        return lesson;
    }

    public void setLesson(Set<Lesson> lesson) {
        this.lesson = lesson;
    }
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
