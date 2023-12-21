package com.example.bookbti.controller;

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

    @GetMapping("/count")
    public Long getBooksCount() {
        return bookService.getBooksCount();
    }


    @PostMapping
    public ResponseEntity<List<Long>> saveBook(@RequestBody List<SaveBookRequest> request) {
        List<Long> bookIds = bookService.saveBook(request).stream()
                .map(Book::getId)
                .collect(toList());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookIds);
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
