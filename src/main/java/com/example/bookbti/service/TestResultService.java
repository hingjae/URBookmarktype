package com.example.bookbti.service;

import com.example.bookbti.dto.testresult.SaveTestResultRequest;
import com.example.bookbti.entity.BookmarkType;
import com.example.bookbti.entity.TestResult;
import com.example.bookbti.repository.BookmarkTypeRepository;
import com.example.bookbti.repository.TestResultRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TestResultService {

    private final TestResultRepository testResultRepository;
    private final BookmarkTypeRepository bookmarkTypeRepository;

    @Transactional(readOnly = true)
    public Long getCount() {
        return testResultRepository.count();
    }

    @Transactional
    public String save(SaveTestResultRequest request) {
        BookmarkType bookmarkType = bookmarkTypeRepository.findById(request.getBookmarkId())
                .orElseThrow(EntityNotFoundException::new);

        return testResultRepository.save(
                TestResult.builder()
                        .id(UUID.randomUUID().toString())
                        .bookmarkType(bookmarkType)
                        .build()
        ).getId();
    }
}
