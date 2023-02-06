package com.sparta.myblog.controller;

import com.sparta.myblog.dto.BlogRequestDto;
import com.sparta.myblog.dto.BlogResponseDto;
import com.sparta.myblog.dto.SendMessageDto;
import com.sparta.myblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // SpringFrameWork에서 제공하는 어노테이션, RESTAPI 컨트롤러 클래스에 사용됨. @ResponseBody 어노테이션이 적용된 메서드를 자동으로 실행한 결과를 HTTP 응답으로 반환.
@RequiredArgsConstructor // 클래스의 final 필드와 @NonNull 필드를 포함하는 생성자를 자동으로 생성
@RequestMapping("/api") // SpringMVC의 주요 어노테이션, Controller method 가 어떤 url 요청에 매핑되어야 하는지 지정.
public class BlogController {
    private final BlogService blogService;

    // 1. @PathVariable :URL 경로에서 추출한 변수 값을 메서드의 파라미터로 전달할 때 사용됨.
    // 2.

    // 요구사항1. 전체 게시글 목록 조회 API (GET)
    @GetMapping("/blogs")
    public List<BlogResponseDto> getBlogs() {
        return blogService.getBlogs();
    }

    // 요구사항2. 게시글 작성 API (PST)
    @PostMapping("/blogs")
    public BlogResponseDto createBlog(@RequestBody BlogRequestDto requestDto) {
        return blogService.createBlog(requestDto);
    }

    // 요구사항3. 선택한 게시글 조회 API (GET)
    @GetMapping("/blogs/{id}")
    public BlogResponseDto getBlogs(@PathVariable Long id) {
        return blogService.getBlogs(id);
    }


    // 요구사항4. 선택한 게시글 수정 API (PUT)
    @PutMapping("/blogs/{id}")
    public BlogResponseDto updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        return blogService.updateBlog(id, requestDto);
    }

    // 요구사항5. 선택한 게시글 삭제 API (DEL)
    @DeleteMapping("/blogs/{id}")
    public SendMessageDto deleteBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        return blogService.deleteBlog(id,requestDto);
    }
}
