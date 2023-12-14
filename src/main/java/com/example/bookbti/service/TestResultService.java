package com.example.bookbti.service;

import com.example.bookbti.dto.testresult.BookmarkTypeAndBookListResponse;
import com.example.bookbti.dto.testresult.SaveTestResultRequest;
import com.example.bookbti.entity.Book;
import com.example.bookbti.entity.BookmarkType;
import com.example.bookbti.entity.TestResult;
import com.example.bookbti.repository.BookmarkTypeRepository;
import com.example.bookbti.repository.TestResultRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TestResultService {

    private final BookService bookService;
    private final BookmarkTypeRepository bookmarkTypeRepository;
    private final TestResultRepository testResultRepository;

    @Transactional
    public Long saveTestResult(SaveTestResultRequest request) {
        Book book = bookService.saveBook(request.toSaveBookRequest());
        BookmarkType bookmarkType = bookmarkTypeRepository.findByTypeCode(request.getTypeCode())
                .orElseThrow(EntityNotFoundException::new);
        return testResultRepository.save(
                TestResult.builder()
                        .book(book)
                        .bookmarkType(bookmarkType)
                        .build()
        ).getId();
    }

    @Transactional(readOnly = true)
    public BookmarkTypeAndBookListResponse getTestResult(String typeCode) {
        return null;
    }
}
