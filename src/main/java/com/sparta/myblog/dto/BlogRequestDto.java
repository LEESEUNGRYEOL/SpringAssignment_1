package com.sparta.myblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlogRequestDto {
    private String author;
    private String contents;
    private String title;
    private String password;
}
