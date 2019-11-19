package com.courses.controller;

import com.courses.dao.LessonDAO;
import com.courses.model.Lesson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {
    private LessonDAO lessonDAO;

    @Autowired
    public LessonController(LessonDAO lessonDAO) {
        this.lessonDAO = lessonDAO;
    }

    @GetMapping("/api/lesson/{id}")
    public Lesson getLesson(@PathVariable Long id) {
        return lessonDAO.findById(id).get();
    }

    @GetMapping(value = "/api/lesson", produces = "application/json")
    public List<Lesson> getLessons() {
        return lessonDAO.findAll();
    }

    @PostMapping(value = "/api/lesson", consumes = "application/json", produces = "application/json")
    public Lesson addLesson(@RequestBody Lesson lesson) {
        lessonDAO.save(lesson);
        return lesson;
    }

    @PatchMapping(value = "/api/lesson/{id}", consumes = "application/json", produces = "application/json")
    public Lesson updateLesson(@PathVariable Long id, @RequestBody Lesson newLesson) {
        Lesson lessonFromDb = lessonDAO.findById(id).get();
        if (lessonFromDb != null){
            lessonFromDb = lessonDAO.findById(id).get();
            BeanUtils.copyProperties(newLesson, lessonFromDb);
            lessonDAO.save(lessonFromDb);
            return lessonFromDb;
        }
        return null;
    }

    @DeleteMapping(value = "/api/lesson/{id}", consumes = "application/json", produces = "application/json")
    public void deleteLesson(@PathVariable Long id){
        lessonDAO.deleteById(id);
    }

}
