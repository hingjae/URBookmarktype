package com.example.bookbti.controller;

import com.example.bookbti.dto.testresult.TestResultCountResponse;
import com.example.bookbti.service.TestResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/testResults")
@RestController
public class TestResultApiController {

    private final TestResultService testResultService;

    /**
     * 테스트 참여 횟수
     */
    @GetMapping("/count")
    public ResponseEntity<TestResultCountResponse> getTestResultCount() {
        Long count = testResultService.getCount();
        return ResponseEntity.ok()
                .body(TestResultCountResponse.of(count));
    }
}
