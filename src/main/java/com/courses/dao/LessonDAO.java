package com.courses.dao;

import com.courses.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LessonDAO extends JpaRepository<Lesson, Long> {
    List<Lesson> findAll();
    Optional<Lesson> findById(Long id);
    Lesson testIsDone(Long id);
}
