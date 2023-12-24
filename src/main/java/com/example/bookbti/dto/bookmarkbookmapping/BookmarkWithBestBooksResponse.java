package com.example.bookbti.dto.bookmarkbookmapping;

import com.example.bookbti.entity.BookmarkType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BookmarkWithBestBooksResponse {
    private String bookmarkImageUrl;
    private String bookmarkNickname;
    private String bookmarkDescription;
    private List<BookmarkBookMappingResponse> books;

    @Builder
    private BookmarkWithBestBooksResponse(String bookmarkImageUrl, String bookmarkNickname, String bookmarkDescription, List<BookmarkBookMappingResponse> books) {
        this.bookmarkImageUrl = bookmarkImageUrl;
        this.bookmarkNickname = bookmarkNickname;
        this.bookmarkDescription = bookmarkDescription;
        this.books = books;
    }

    public static BookmarkWithBestBooksResponse from(BookmarkType bookmarkType, List<BookmarkBookMappingResponse> books) {
        return BookmarkWithBestBooksResponse.builder()
                .bookmarkImageUrl(bookmarkType.getImageUrl())
                .bookmarkNickname(bookmarkType.getNickname())
                .bookmarkDescription(bookmarkType.getDescription())
                .books(books)
                .build();
    }
}
