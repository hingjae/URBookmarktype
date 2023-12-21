package com.example.bookbti.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String title;
    @Column(nullable = false) private String pageUrl;
    @Column(nullable = false) private String imageUrl;
    @Column(nullable = false) private String author;
    @Column(nullable = false) private String isbn;
    @Lob private String description;

    @Builder
    private Book(Long id, String title, String pageUrl, String imageUrl, String author, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.pageUrl = pageUrl;
        this.imageUrl = imageUrl;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
    }
}
