package com.example.bookbti.dto.bookmarkbookmapping;

import com.example.bookbti.dto.book.SaveBookRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookmarkBookMappingRequest {
    private String bookmarkTypeId;
    private List<SaveBookRequest> books;
}
