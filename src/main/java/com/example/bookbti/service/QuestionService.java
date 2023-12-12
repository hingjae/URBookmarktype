package com.example.bookbti.service;

import com.example.bookbti.dto.QuestionWithAnswersResponse;
import com.example.bookbti.repository.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Transactional(readOnly = true)
    public QuestionWithAnswersResponse getQuestionWithAnswers(Long id) {
        return questionRepository.findById(id)
                .map(QuestionWithAnswersResponse::from)
                .orElseThrow(EntityNotFoundException::new);
    }
}
