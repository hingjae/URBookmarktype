package com.example.bookbti.dto.testresult;

import com.example.bookbti.dto.book.SaveBookRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SaveTestResultRequest {
    private Long resultTypeId;
    private String bookTitle;
    private String bookPageUrl;
    private String bookImageUrl;
    private String bookAuthor;
    private String bookIsbn;

    public SaveBookRequest toSaveBookRequest() {
        return SaveBookRequest.builder()
                .title(bookTitle)
                .pageUrl(bookPageUrl)
                .imageUrl(bookImageUrl)
                .author(bookAuthor)
                .isbn(bookIsbn)
                .build();
    }
}
