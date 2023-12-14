package com.example.bookbti.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookmark_type_id")
    private BookmarkType bookmarkType;

    @Builder
    private TestResult(Long id, Book book, BookmarkType bookmarkType) {
        this.id = id;
        this.book = book;
        this.bookmarkType = bookmarkType;
    }
}
