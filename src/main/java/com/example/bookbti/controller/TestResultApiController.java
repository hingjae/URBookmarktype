package com.example.bookbti.controller;

import com.example.bookbti.dto.testresult.SaveTestResultRequest;
import com.example.bookbti.service.TestResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/testResults")
@RequiredArgsConstructor
@RestController
public class TestResultApiController {

    private final TestResultService testResultService;

    @PostMapping
    public ResponseEntity<Long> saveTestResult(@RequestBody SaveTestResultRequest request) {
        Long testResultId = testResultService.saveTestResult(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(testResultId);
    }
}
