package com.example.bookbti.repository;

import com.example.bookbti.entity.BookmarkType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookmarkTypeRepository extends JpaRepository<BookmarkType, String> {
    Optional<BookmarkType> findByTypeCode(String typeCode);
}
