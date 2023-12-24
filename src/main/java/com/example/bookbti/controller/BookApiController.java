package com.example.bookbti.controller;

import com.example.bookbti.dto.book.BookCountResponse;
import com.example.bookbti.dto.book.BookResponse;
import com.example.bookbti.dto.book.SaveBookRequest;
import com.example.bookbti.entity.Book;
import com.example.bookbti.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@RequestMapping("/api/books")
@RestController
public class BookApiController {

    private final BookService bookService;

    /**
     * 추천한 책 수
     */
    @GetMapping("/count")
    public ResponseEntity<BookCountResponse> getBookCount() {
        Long count = bookService.getCount();
        return ResponseEntity.ok()
                .body(BookCountResponse.of(count));
    }

}
