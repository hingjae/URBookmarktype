package com.example.bookbti.repository;

import com.example.bookbti.entity.Book;
import com.example.bookbti.entity.BookmarkType;
import com.example.bookbti.entity.BookmarkBookMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookmarkBookMappingRepository extends JpaRepository<BookmarkBookMapping, Long> {
    Optional<BookmarkBookMapping> findByBookmarkTypeAndBook(BookmarkType bookmarkType, Book book);
}
