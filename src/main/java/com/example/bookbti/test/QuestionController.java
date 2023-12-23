package com.example.bookbti.test;

import com.example.bookbti.dto.question.QuestionWithAnswersResponse;
import com.example.bookbti.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@RequestMapping("/questions")
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public String getQuestions(Model model) {
        QuestionWithAnswersResponse questionWithAnswers1 = questionService.getQuestionWithAnswers(1L);
        QuestionWithAnswersResponse questionWithAnswers2 = questionService.getQuestionWithAnswers(2L);
        QuestionWithAnswersResponse questionWithAnswers3 = questionService.getQuestionWithAnswers(3L);
        QuestionWithAnswersResponse questionWithAnswers4 = questionService.getQuestionWithAnswers(4L);
        model.addAttribute("question1", questionWithAnswers1);
        model.addAttribute("question2", questionWithAnswers2);
        model.addAttribute("question3", questionWithAnswers3);
        model.addAttribute("question4", questionWithAnswers4);
        return "questions";
    }

    @PostMapping
    public String postQuestions(@RequestParam String bookmarkTypeId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("bookmarkTypeId", bookmarkTypeId);
        return "redirect:/book-search";
    }
}
