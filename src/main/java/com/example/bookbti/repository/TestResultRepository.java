package com.example.bookbti.repository;

import com.example.bookbti.entity.Book;
import com.example.bookbti.entity.BookmarkType;
import com.example.bookbti.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    Optional<TestResult> findByBookmarkTypeAndBook(BookmarkType bookmarkType, Book book);
}
