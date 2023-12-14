package com.example.bookbti.dto.book;

import com.example.bookbti.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SaveBookRequest {
    private String title;
    private String pageUrl;
    private String imageUrl;
    private String author;
    private String isbn;

    @Builder
    public SaveBookRequest(String title, String pageUrl, String imageUrl, String author, String isbn) {
        this.title = title;
        this.pageUrl = pageUrl;
        this.imageUrl = imageUrl;
        this.author = author;
        this.isbn = isbn;
    }

    public Book toEntity() {
        return Book.builder()
                .title(title)
                .pageUrl(pageUrl)
                .imageUrl(imageUrl)
                .author(author)
                .isbn(isbn)
                .build();
    }
}
