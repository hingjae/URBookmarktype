package com.example.bookbti.dto.bookmarkbookmapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookmarkBookMappingResponse {
    private Long bookId;
    private String bookTitle;
    private String bookPageUrl;
    private String bookImageUrl;
    private String bookAuthor;
    private String bookIsbn;
    private String bookDescription;
    private int count;
}
