package com.example.bookbti.exception;

public class BookLimitExceededException extends RuntimeException {
    private static final String MESSAGE = "책은 최대 3권까지 고를 수 있습니다.";

    public BookLimitExceededException() {
        super(MESSAGE);
    }
}
