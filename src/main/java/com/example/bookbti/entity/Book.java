package com.example.bookbti.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String content;
    @Column(nullable = false) private String pageUrl;
    @Column(nullable = false) private String imageUrl;
    @Column(nullable = false) private String author;
    @Column(nullable = false) private String isbn;
}
