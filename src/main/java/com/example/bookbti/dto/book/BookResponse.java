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
    private final String description;
    @Builder
    private BookResponse(Long id, String title, String pageUrl, String imageUrl, String author, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.pageUrl = pageUrl;
        this.imageUrl = imageUrl;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
    }

    public static BookResponse from(Book entity) {
        return BookResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .pageUrl(entity.getPageUrl())
                .imageUrl(entity.getImageUrl())
                .author(entity.getAuthor())
                .isbn(entity.getIsbn())
                .description(entity.getDescription())
                .build();
    }

}
