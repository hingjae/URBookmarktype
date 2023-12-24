package com.example.bookbti.repository;

import com.example.bookbti.dto.bookmarkbookmapping.BookmarkBookMappingResponse;
import com.example.bookbti.entity.Book;
import com.example.bookbti.entity.BookmarkType;
import com.example.bookbti.entity.BookmarkBookMapping;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookmarkBookMappingRepository extends JpaRepository<BookmarkBookMapping, Long> {
    Optional<BookmarkBookMapping> findByBookmarkTypeAndBook(BookmarkType bookmarkType, Book book);

    @Query("SELECT new com.example.bookbti.dto.bookmarkbookmapping.BookmarkBookMappingResponse(b.id, b.title, b.pageUrl, b.imageUrl, b.author, b.isbn, b.description, bbm.count) " +
            "FROM BookmarkBookMapping bbm " +
            "INNER JOIN bbm.bookmarkType bt " +
            "INNER JOIN bbm.book b " +
            "WHERE bt.id = :id " +
            "ORDER BY bbm.count DESC ")
    List<BookmarkBookMappingResponse> findBestBookByBookmarkId(@Param("id") String bookmarkId, Pageable pageable);


}
