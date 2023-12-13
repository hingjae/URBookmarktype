package com.example.bookbti.repository;

import com.example.bookbti.entity.Question;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @EntityGraph(attributePaths = "answers")
    Optional<Question> findById(Long id);

    @Override
    @EntityGraph(attributePaths = "answers")
    List<Question> findAll();
}
