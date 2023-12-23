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
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookmark_type_id")
    private BookmarkType bookmarkType;

    @Builder
    private TestResult(String id, BookmarkType bookmarkType) {
        this.id = id;
        this.bookmarkType = bookmarkType;
    }
}
