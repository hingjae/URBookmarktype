package com.example.bookbti.dto.book;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BookCountResponse {
    private Long bookCount;

    @Builder
    private BookCountResponse(Long bookCount) {
        this.bookCount = bookCount;
    }

    public static BookCountResponse of(Long count) {
        return BookCountResponse.builder()
                .bookCount(count)
                .build();
    }
}
