package com.example.bookbti.service;

import com.example.bookbti.dto.book.SaveBookRequest;
import com.example.bookbti.dto.bookmarkbookmapping.BookmarkBookMappingRequest;
import com.example.bookbti.dto.bookmarkbookmapping.BookmarkBookMappingResponse;
import com.example.bookbti.dto.bookmarkbookmapping.BookmarkWithBestBooksResponse;
import com.example.bookbti.entity.Book;
import com.example.bookbti.entity.BookmarkBookMapping;
import com.example.bookbti.entity.BookmarkType;
import com.example.bookbti.entity.TestResult;
import com.example.bookbti.repository.BookmarkBookMappingRepository;
import com.example.bookbti.repository.BookmarkTypeRepository;
import com.example.bookbti.repository.TestResultRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookmarkBookMappingService {

    private final BookService bookService;
    private final BookmarkTypeRepository bookmarkTypeRepository;
    private final BookmarkBookMappingRepository bookmarkBookMappingRepository;
    private final TestResultRepository testResultRepository;

    private static final int FIRST_PAGE = 0;
    private static final int SIZE_OF_BOOKS = 3;

    @Transactional
    public List<Long> saveBookmarkBookMapping(BookmarkBookMappingRequest request) {
        BookmarkType bookmarkType = bookmarkTypeRepository.findById(request.getBookmarkId())
                .orElseThrow(EntityNotFoundException::new);
        saveTestResult(bookmarkType);
        List<SaveBookRequest> saveBookRequests = request.getBooks();
        if (saveBookRequests.isEmpty()) {
            return List.of();
        } else {
            List<Book> books = bookService.saveBook(saveBookRequests);
            // 예외 추가
            if (saveBookRequests.size() > 3) {
                throw new RuntimeException();
            }
            return books.stream()
                    .map(book -> {
                                BookmarkBookMapping bookmarkBookMapping = bookmarkBookMappingRepository.findByBookmarkTypeAndBook(bookmarkType, book)
                                        .orElseGet(() -> saveBookmarkBookMapping(bookmarkType, book));
                                bookmarkBookMapping.countIncrease();
                                return bookmarkBookMapping.getId();
                            }
                    )
                    .collect(Collectors.toList());
        }

    }

    private void saveTestResult(BookmarkType bookmarkType) {
        testResultRepository.save(TestResult.builder()
                .id(UUID.randomUUID().toString())
                .bookmarkType(bookmarkType)
                .build()
        );
    }

    private BookmarkBookMapping saveBookmarkBookMapping(BookmarkType bookmarkType, Book book) {
        return bookmarkBookMappingRepository.save(
                BookmarkBookMapping.builder()
                        .bookmarkType(bookmarkType)
                        .book(book)
                        .count(0)
                        .build()
        );
    }

    @Transactional(readOnly = true)
    public BookmarkWithBestBooksResponse getBookmarkWithBestBook(String bookmarkId) {
        BookmarkType bookmarkType = bookmarkTypeRepository.findById(bookmarkId)
                .orElseThrow(EntityNotFoundException::new);
        List<BookmarkBookMappingResponse> bestBook = bookmarkBookMappingRepository.findBestBookByBookmarkId(bookmarkId, PageRequest.of(FIRST_PAGE, SIZE_OF_BOOKS));

        return BookmarkWithBestBooksResponse.from(bookmarkType, bestBook);
    }
}
