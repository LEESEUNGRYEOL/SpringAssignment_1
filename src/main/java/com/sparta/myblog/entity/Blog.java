package com.sparta.myblog.entity;


import com.sparta.myblog.dto.BlogRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Blog extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String title;
//    private String delMsg;

    // 생성자.
    public Blog (BlogRequestDto requestDto)
    {
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
    }
    public void update (BlogRequestDto requestDto)
    {
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }

}
