package com.example.bookbti.dto.testresult;

import com.example.bookbti.dto.book.SaveBookRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SaveTestResultRequest {
    private Long bookmarkTypeId;
    private List<SaveBookRequest> books;
}
