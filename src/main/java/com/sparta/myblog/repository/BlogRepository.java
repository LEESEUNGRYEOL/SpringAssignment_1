package com.sparta.myblog.repository;

import com.sparta.myblog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    // 요청사항 : 수정된순이 아니라, 글이 작성된 순으로 정렬바람.
    List<Blog> findAllByOrderByCreatedAtAsc();
}
