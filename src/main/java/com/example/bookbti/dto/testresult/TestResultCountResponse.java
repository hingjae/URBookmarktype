package com.example.bookbti.dto.testresult;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TestResultCountResponse {

    private Long testCount;

    @Builder
    private TestResultCountResponse(Long testCount) {
        this.testCount = testCount;
    }

    public static TestResultCountResponse of(Long count) {
        return TestResultCountResponse.builder()
                .testCount(count)
                .build();
    }
}
