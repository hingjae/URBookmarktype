package com.example.bookbti.controller;

import com.example.bookbti.dto.testresult.SaveTestResultRequest;
import com.example.bookbti.dto.testresult.SaveTestResultResponse;
import com.example.bookbti.dto.testresult.TestResultCountResponse;
import com.example.bookbti.service.TestResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 테스트 결과 저장
     */
    @PostMapping
    public ResponseEntity<SaveTestResultResponse> saveTestResult(@RequestBody SaveTestResultRequest request) {
        String testResultId = testResultService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SaveTestResultResponse.of(testResultId));
    }
}
