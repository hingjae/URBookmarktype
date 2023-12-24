package com.example.bookbti.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/book-search")
@RequiredArgsConstructor
@Controller
public class BookSearchController {

    @GetMapping
    public String bookSearchView(@RequestParam String bookmarkId, Model model) {
        model.addAttribute("bookmarkId", bookmarkId);
        return "book-search";
    }

    @PostMapping
    public String saveResult() {
        return "redirect:/home";
    }
}
