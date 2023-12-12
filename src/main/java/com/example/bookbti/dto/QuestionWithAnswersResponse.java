package com.example.bookbti.dto;

import com.example.bookbti.entity.Question;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class QuestionWithAnswersResponse {
    private final Long questionId;
    private final String questionContent;
    private final List<AnswerResponse> answers;

    @Builder
    public QuestionWithAnswersResponse(Long questionId, String questionContent, List<AnswerResponse> answers) {
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.answers = answers;
    }

    public static QuestionWithAnswersResponse from(Question entity) {
        return QuestionWithAnswersResponse.builder()
                .questionId(entity.getId())
                .questionContent(entity.getContent())
                .answers(
                        entity.getAnswers().stream()
                                .map(AnswerResponse::from)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
