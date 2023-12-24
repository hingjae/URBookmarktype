package com.example.bookbti.test;

import com.example.bookbti.dto.bookmarkbookmapping.BookmarkWithBestBooksResponse;
import com.example.bookbti.service.BookmarkBookMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/bookmark-book")
@RequiredArgsConstructor
@Controller
public class BookmarkBookMappingController {

    private final BookmarkBookMappingService bookmarkBookMappingService;

    @GetMapping
    public String getBookmarkWithBestBook(@RequestParam String bookmarkId, Model model) {
        BookmarkWithBestBooksResponse bookmarkWithBestBooks = bookmarkBookMappingService.getBookmarkWithBestBook(bookmarkId);
        model.addAttribute("bookmarkImageUrl", bookmarkWithBestBooks.getBookmarkImageUrl());
        model.addAttribute("bookmarkNickname", bookmarkWithBestBooks.getBookmarkNickname());
        model.addAttribute("bookmarkDescription", bookmarkWithBestBooks.getBookmarkDescription());
        model.addAttribute("books", bookmarkWithBestBooks.getBooks());
        return "bookmark-book";
    }
}
