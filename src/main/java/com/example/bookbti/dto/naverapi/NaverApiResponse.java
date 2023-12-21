package com.example.bookbti.dto.naverapi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class NaverApiResponse {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private final List<ItemResponse> items = new ArrayList<>();
    @Getter @Setter
    static class ItemResponse {
        private String title;
        private String link;
        private String image;
        private String author;
        private String publisher;
        private String pubdate;
        private String isbn;
        private String description;
    }
}
