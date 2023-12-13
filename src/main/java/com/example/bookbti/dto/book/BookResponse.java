package com.example.bookbti.dto.book;

import com.example.bookbti.entity.Book;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BookResponse {
    private final Long id;
    private final String title;
    private final String pageUrl;
    private final String imageUrl;
    private final String author;
    private final String isbn;

    @Builder
    private BookResponse(Long id, String title, String pageUrl, String imageUrl, String author, String isbn) {
        this.id = id;
        this.title = title;
        this.pageUrl = pageUrl;
        this.imageUrl = imageUrl;
        this.author = author;
        this.isbn = isbn;
    }

    public static BookResponse from(Book entity) {
        return BookResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .pageUrl(entity.getPageUrl())
                .imageUrl(entity.getImageUrl())
                .author(entity.getAuthor())
                .isbn(entity.getIsbn())
                .build();
    }
}
