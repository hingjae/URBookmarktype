package com.example.bookbti.service;

import com.example.bookbti.dto.book.SaveBookRequest;
import com.example.bookbti.entity.Book;
import com.example.bookbti.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public Long getCount() {
        return bookRepository.count();
    }

    @Transactional
    public List<Book> saveBook(List<SaveBookRequest> request) {
        return request.stream()
                .map(book -> bookRepository.findByTitleAndIsbn(book.getTitle(), book.getIsbn())
                                .orElseGet(() -> bookRepository.save(book.toEntity()))
                )
                .collect(Collectors.toList());
    }

}
