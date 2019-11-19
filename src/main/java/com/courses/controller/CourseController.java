package com.courses.controller;

import com.courses.dao.CourseDAO;
import com.courses.model.Course;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {
    private CourseDAO courseDAO;

    @Autowired
    public CourseController(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @GetMapping("api/course/{id}")
    public Course getCourse(@PathVariable Long id){
        return courseDAO.findById(id).get();
    }

    @PostMapping(value = "/api/course", consumes = "application/json", produces = "application/json")
    public Course addCourse(@RequestBody Course course){
        courseDAO.save(course);
        return course;
    }

    @PatchMapping(value = "/api/course{id}", consumes = "application/json", produces = "application/json")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course newCourse){
        Course courseFromDb = courseDAO.findById(id).get();
        if (courseFromDb !=null){
            courseFromDb = courseDAO.findById(id).get();
            BeanUtils.copyProperties(newCourse, courseFromDb);
            courseDAO.save(courseFromDb);
            return courseFromDb;
        }
        return null;
    }

    @DeleteMapping(value = "/api/course{id}", consumes = "application/json", produces = "application/json")
    public void deleteCourse(@PathVariable Long id){
        courseDAO.deleteById(id);
    }
}
