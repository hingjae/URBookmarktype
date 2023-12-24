package com.example.bookbti.controller;

import com.example.bookbti.dto.bookmarkbookmapping.BookmarkBookMappingRequest;
import com.example.bookbti.dto.bookmarkbookmapping.BookmarkBookMappingResponse;
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

    @PostMapping
    public ResponseEntity<List<Long>> saveBookmarkBookMapping(@RequestBody BookmarkBookMappingRequest request) {
        List<Long> bookmarkBookMappingIds = bookmarkBookMappingService.saveBookmarkBookMapping(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookmarkBookMappingIds);
    }

    @GetMapping
    public ResponseEntity<List<BookmarkBookMappingResponse>> getBookmarkBookMapping(@RequestParam String bookmarkTypeId) {
        List<BookmarkBookMappingResponse> bookmarkWithBestBooks = bookmarkBookMappingService.getBookmarkWithBestBook(bookmarkTypeId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookmarkWithBestBooks);
    }
}
