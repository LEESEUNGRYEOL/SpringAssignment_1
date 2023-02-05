package com.sparta.myblog.service;


import com.sparta.myblog.dto.BlogRequestDto;
import com.sparta.myblog.dto.BlogResponseDto;
import com.sparta.myblog.dto.SendMessageDto;
import com.sparta.myblog.entity.Blog;
import com.sparta.myblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    // 요구사항1. 전체 게시글 목록 조회
    // (이때 RSP 로 전달해야하는 것이 List 가 아닌, DTO 로 전달해야함.)
    @Transactional(readOnly = true)
    public List<BlogResponseDto> getBlogs() {
        List <Blog> blogList = blogRepository.findAllByOrderByCreatedAtAsc();
        List <BlogResponseDto> blogResponseDtoList = new ArrayList<>();
        for (Blog blog : blogList) {
            BlogResponseDto tmp = new BlogResponseDto(blog);
            blogResponseDtoList.add(tmp);
        }
        return blogResponseDtoList;
    }

    // 요구사항2. 게시글 작성
    @Transactional
    public BlogResponseDto createBlog(BlogRequestDto requestDto) {
            Blog blog = new Blog(requestDto);
            blogRepository.save(blog);
            BlogResponseDto blogResponseDto = new BlogResponseDto(blog);
            return blogResponseDto;
    }


    // 요구사항3. 선택한 게시글 조회
    @Transactional(readOnly = true)
    public BlogResponseDto getBlogs(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당글이 없습니다.")
        );
        BlogResponseDto blogResponseDto = new BlogResponseDto(blog);
        return blogResponseDto;
    }

    // 요구사항4. 선택한 게시글 수정
    @Transactional
    public BlogResponseDto updateBlog(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new RuntimeException("아이디가 존재하지 않습니다.")
        );
        if(requestDto.getPassword().equals(blog.getPassword()))
        {
            blog.update(requestDto);
        }
        BlogResponseDto blogResponseDto = new BlogResponseDto(blog);
        return blogResponseDto;
    }

    // 요구사항5. 선택한 게시글 삭제
    @Transactional
    public SendMessageDto deleteBlog(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        SendMessageDto sendMessageDto = new SendMessageDto();
        if(requestDto.getPassword().equals(blog.getPassword()))
        {
            blogRepository.deleteById(id);
            sendMessageDto.sendMessage("삭제완료");
            return sendMessageDto;
        }
        else{
            sendMessageDto.sendMessage("삭제실패");
            return sendMessageDto;
        }

    }

}
