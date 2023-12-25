package com.example.bookbti.dto.testresult;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SaveTestResultResponse {
    private String testResultId;

    @Builder
    private SaveTestResultResponse(String testResultId) {
        this.testResultId = testResultId;
    }

    public static SaveTestResultResponse of(String testResultId) {
        return SaveTestResultResponse.builder()
                .testResultId(testResultId)
                .build();
    }
}
