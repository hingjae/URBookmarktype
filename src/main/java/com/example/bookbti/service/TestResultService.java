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

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TestResultService {

    private final BookService bookService;
    private final BookmarkTypeRepository bookmarkTypeRepository;
    private final TestResultRepository testResultRepository;

    @Transactional
    public List<Long> saveTestResult(SaveTestResultRequest request) {
        BookmarkType bookmarkType = bookmarkTypeRepository.findById(request.getBookmarkTypeId())
                .orElseThrow(EntityNotFoundException::new);
        List<Book> books = bookService.saveBook(request.getBooks());

        //        TestResult testResult = testResultRepository.findByBookmarkTypeAndBook(bookmarkType, book)
//                .orElseGet(() -> saveTestResult(bookmarkType, book));
//        testResult.countIncrease();
        return books.stream()
                .map(book -> {
                            TestResult testResult = testResultRepository.findByBookmarkTypeAndBook(bookmarkType, book)
                                    .orElseGet(() -> saveTestResult(bookmarkType, book));
                            testResult.countIncrease();
                            return testResult.getId();
                        }
                )
                .collect(Collectors.toList());
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
    public BookmarkTypeAndBookListResponse getTestResult(Long bookmarkId) {
        return null;
    }

    @Transactional(readOnly = true)
    public Long getCount() {
        return testResultRepository.count();
    }
}
