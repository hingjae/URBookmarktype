package com.example.bookbti.catcher;

import com.example.bookbti.exception.BookLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookLimitExceptionCatcher {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BookLimitExceededException.class)
    public ResponseEntity<ErrorResponse> handleBookLimitExceededException(BookLimitExceededException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    public static class ErrorResponse {
        private final String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
