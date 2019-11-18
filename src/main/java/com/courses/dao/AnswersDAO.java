package com.courses.dao;

import com.courses.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswersDAO extends JpaRepository<Answer, Long> {

    Optional<Answer> findById(Long id);

    List<Answer> findAll();
}
