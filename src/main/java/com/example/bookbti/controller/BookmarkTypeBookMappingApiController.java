package com.example.bookbti.controller;

import com.example.bookbti.dto.bookmarkbookmapping.BookmarkBookMappingRequest;
import com.example.bookbti.dto.bookmarkbookmapping.BookmarkWithBestBooksResponse;
import com.example.bookbti.service.BookmarkBookMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/bookmarkBookMapping")
@RequiredArgsConstructor
@RestController
public class BookmarkTypeBookMappingApiController {

    private final BookmarkBookMappingService bookmarkBookMappingService;

    /**
     * 책갈피 타입과 책을 맵핑해서 저장
     */
    @PostMapping
    public ResponseEntity<List<Long>> saveBookmarkBookMapping(@RequestBody BookmarkBookMappingRequest request) {
        List<Long> bookmarkBookMappingIds = bookmarkBookMappingService.saveBookmarkBookMapping(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookmarkBookMappingIds);
    }

    /**
     * 책갈피 타입 별 책 Best 3을 반환
     */
    @GetMapping
    public ResponseEntity<BookmarkWithBestBooksResponse> getBookmarkBookMapping(@RequestParam String bookmarkId) {
        BookmarkWithBestBooksResponse bookmarkWithBestBooks = bookmarkBookMappingService.getBookmarkWithBestBook(bookmarkId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookmarkWithBestBooks);
    }
}
