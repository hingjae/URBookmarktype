package com.example.bookbti.service;

import com.example.bookbti.dto.question.QuestionWithAnswersResponse;
import com.example.bookbti.repository.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Transactional(readOnly = true)
    public QuestionWithAnswersResponse getQuestionWithAnswers(Long questionId) {
        return questionRepository.findById(questionId)
                .map(QuestionWithAnswersResponse::from)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<QuestionWithAnswersResponse> getAllQuestionsWithAnswers() {
        return questionRepository.findAll().stream()
                .map(QuestionWithAnswersResponse::from)
                .collect(Collectors.toList());
    }
}
