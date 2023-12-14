package com.example.bookbti.controller;

import com.example.bookbti.dto.book.BookResponse;
import com.example.bookbti.dto.book.SaveBookRequest;
import com.example.bookbti.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/books")
@RestController
public class BookApiController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Long> saveBook(@RequestBody SaveBookRequest request) {
        Long bookId = bookService.saveBook(request).getId();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookId);
    }


    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long bookId) {
        BookResponse book = bookService.getBookById(bookId);
        return ResponseEntity.ok()
                .body(book);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getBooksByTitle(String title) {
        List<BookResponse> books = bookService.getBooksByTitle(title);
        return ResponseEntity.ok()
                .body(books);

    }

}
