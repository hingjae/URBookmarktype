package com.example.bookbti.service;

import com.example.bookbti.dto.book.BookResponse;
import com.example.bookbti.dto.book.SaveBookRequest;
import com.example.bookbti.entity.Book;
import com.example.bookbti.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public Book saveBook(SaveBookRequest request) {
        return bookRepository.findByTitleAndIsbn(request.getTitle(), request.getIsbn())
                .orElseGet(() -> bookRepository.save(request.toEntity()));
    }

    @Transactional(readOnly = true)
    public BookResponse getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .map(BookResponse::from)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<BookResponse> getBooksByTitle(String title) {
        return bookRepository.findFirst3ByTitleContaining(title).stream()
                .map(BookResponse::from)
                .collect(Collectors.toList());
    }

}
