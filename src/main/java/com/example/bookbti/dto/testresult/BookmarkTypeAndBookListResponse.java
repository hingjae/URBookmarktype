package com.example.bookbti.dto.testresult;

import com.example.bookbti.dto.book.BookResponse;

import java.util.List;

public class BookmarkTypeAndBookListResponse {
    private String bookmarkTypeCode;
    private String bookmarkTypeNickname;
    private String bookmarkTypeDescription;
    private String bookmarkTypeImageUrl;
    private List<BookResponse> books;
}
