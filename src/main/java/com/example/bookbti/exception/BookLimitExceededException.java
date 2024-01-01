package com.example.bookbti.exception;

public class BookLimitExceededException extends RuntimeException {
    private static final String MESSAGE = "이미 존재하는 아이디 입니다.";

    public BookLimitExceededException() {
        super(MESSAGE);
    }
}
