package com.example.bookbti.dto.book;

import com.example.bookbti.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SaveBookRequest {
    private String title;
    private String pageUrl;
    private String imageUrl;
    private String author;
    private String isbn;

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
