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
        BookmarkType bookmarkType = bookmarkTypeRepository.findById(request.getResultTypeId())
                .orElseThrow(EntityNotFoundException::new);
        Book book = bookService.saveBook(request.toSaveBookRequest());
//        return testResultRepository.save(
//                TestResult.builder()
//                        .book(book)
//                        .bookmarkType(bookmarkType)
//                        .build()
//        ).getId();

        TestResult testResult = testResultRepository.findByBookmarkTypeAndBook(bookmarkType, book)
                .orElseGet(() -> saveTestResult(bookmarkType, book));
        testResult.countIncrease();
        return testResult.getId();
    }

    private TestResult saveTestResult(BookmarkType bookmarkType, Book book) {
        return testResultRepository.save(
                TestResult.builder()
                        .bookmarkType(bookmarkType)
                        .book(book)
                        .count(0)
                        .build()
        );
    }

    @Transactional(readOnly = true)
    public BookmarkTypeAndBookListResponse getTestResult(String typeCode) {
        return null;
    }
}
