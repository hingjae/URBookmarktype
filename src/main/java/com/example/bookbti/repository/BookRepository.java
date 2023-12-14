package com.example.bookbti.repository;

import com.example.bookbti.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findFirst3ByTitleContaining(String title);

    Optional<Book> findByTitleAndIsbn(String title, String isbn);
}
