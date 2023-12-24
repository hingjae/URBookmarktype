package com.example.bookbti.test;

import com.example.bookbti.service.BookService;
import com.example.bookbti.service.TestResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
@RequestMapping("/home")
@RequiredArgsConstructor
@Controller
public class HomeController {
    private final BookService bookService;
    private final TestResultService testResultService;

    @GetMapping
    public String homeView(Model model) {
        model.addAttribute("bookCount", bookService.getCount());
        model.addAttribute("testResultCount", testResultService.getCount());
        return "home";
    }
}


 */