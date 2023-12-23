package com.example.bookbti.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class BookmarkType {

    @Id
    private String id;

    @Column(nullable = false, unique = true) private String typeCode;
    @Column(nullable = false) private String nickname;
    @Column(nullable = false) private String description;
    @Column(nullable = false) private String imageUrl;
}
