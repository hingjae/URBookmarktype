package com.example.bookbti.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookmark_type_id")
    private BookmarkType bookmarkType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    private int count;

    //타입 별 책 개수 증가
    public void countIncrease() {
        this.count = this.count + 1;
    }

    @Builder
    private TestResult(Long id, BookmarkType bookmarkType, Book book, int count) {
        this.id = id;
        this.bookmarkType = bookmarkType;
        this.book = book;
        this.count = count;
    }

}
