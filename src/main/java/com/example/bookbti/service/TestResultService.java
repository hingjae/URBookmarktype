package com.example.bookbti.service;

import com.example.bookbti.repository.TestResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TestResultService {

    private final TestResultRepository testResultRepository;

    @Transactional(readOnly = true)
    public Long getCount() {
        return testResultRepository.count();
    }
}
