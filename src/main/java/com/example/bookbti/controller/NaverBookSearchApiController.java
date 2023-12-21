package com.example.bookbti.controller;

import com.example.bookbti.config.NaverProperties;
import com.example.bookbti.dto.naverapi.NaverApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;

@RequestMapping("/api/book-search")
@RequiredArgsConstructor
@RestController
public class NaverBookSearchApiController {

    private final RestTemplate restTemplate;
    private final NaverProperties naverProperties;

    private static final String NAVER_CLIENT_ID = "X-Naver-Client-Id";
    private static final String NAVER_CLIENT_SECRET = "X-Naver-Client-Secret";

    @GetMapping
    public ResponseEntity<NaverApiResponse> searchBookByParam(String param) throws UnsupportedEncodingException {
        URI uri = UriComponentsBuilder.fromHttpUrl(naverProperties.getUrl())
                .queryParam("query", param)
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "sim")
                .encode(StandardCharsets.UTF_8)
                .build()
                .toUri();

        RequestEntity<Void> request = RequestEntity
                .get(uri)
                .header(NAVER_CLIENT_ID, naverProperties.getClientId())
                .header(NAVER_CLIENT_SECRET, naverProperties.getClientSecret())
                .build();

        return restTemplate.exchange(request, NaverApiResponse.class);
    }
}
