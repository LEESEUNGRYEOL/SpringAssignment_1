package com.sparta.myblog.dto;


import com.sparta.myblog.entity.Blog;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 문제의 조건에서 반환을 무조건 DTO로만 해달라고 했으므로, 다음과 같이 Response DTO 를 생성해서
// 보내줘야 한다. (아마 이유는 보안상, 즉 비밀번호를 줄 수도 있으므로 이에 대한 보안이라고 생각한다.)
@Getter
@NoArgsConstructor
public class BlogResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String author;
//    private String delMsg;
    private LocalDateTime createdat;
    private LocalDateTime modifiedat;

    public BlogResponseDto(Blog blog) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.contents = blog.getContents();
        this.author = blog.getAuthor();
        this.createdat = blog.getCreatedAt();
        this.modifiedat = blog.getModifiedAt();
    }
//    public BlogResponseDto(String delMsg) {
//        this.delMsg = delMsg;
//    }

}
