package com.example.bookbti.controller;

import com.example.bookbti.dto.question.QuestionWithAnswersResponse;
import com.example.bookbti.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/questions")
@RestController
public class QuestionApiController {

    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuestionWithAnswersResponse>> getAllQuestionsWithAnswers() {
        List<QuestionWithAnswersResponse> questions = questionService.getAllQuestionsWithAnswers();
        return ResponseEntity.ok()
                .body(questions);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionWithAnswersResponse> getQuestionWithAnswers(@PathVariable Long questionId) {
        QuestionWithAnswersResponse questions = questionService.getQuestionWithAnswers(questionId);
        return ResponseEntity.ok()
                .body(questions);
    }
}
