package com.example.bookbti.controller;

import com.example.bookbti.dto.testresult.BookmarkTypeAndBookListResponse;
import com.example.bookbti.dto.testresult.SaveTestResultRequest;
import com.example.bookbti.service.TestResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/testResults")
@RequiredArgsConstructor
@RestController
public class TestResultApiController {

    private final TestResultService testResultService;

    @GetMapping("/count")
    public Long getTestResultsCount() {
        return testResultService.getCount();
    }

    @PostMapping
    public ResponseEntity<List<Long>> saveTestResult(@RequestBody SaveTestResultRequest request) {
        List<Long> testResultIds = testResultService.saveTestResult(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(testResultIds);
    }

    @GetMapping
    public ResponseEntity<BookmarkTypeAndBookListResponse> getTestResult(@RequestParam Long bookmarkId) {
        testResultService.getTestResult(bookmarkId);
        return null;
    }
}
