package com.courses.dao;

import com.courses.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionsDAO extends JpaRepository<Question, Long> {

    List<Question> findAll();

    Optional<Question> findById(Long id);

}
