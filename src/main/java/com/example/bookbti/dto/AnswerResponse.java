package com.example.bookbti.dto;

import com.example.bookbti.entity.Answer;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AnswerResponse {
    private final String content;

    @Builder
    private AnswerResponse(String content) {
        this.content = content;
    }

    public static AnswerResponse from(Answer entity) {
        return AnswerResponse.builder()
                .content(entity.getContent())
                .build();
    }
}
