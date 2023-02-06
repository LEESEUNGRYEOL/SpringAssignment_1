package com.sparta.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA entity의 생성, 수정 날짜 등을 자동으로 관리할 수 있다.
// 즉 JPA entity 클래스에서 @CreatedDate, @LastModifiedDate 등의 어노테이션을 사용할 수 있게 된다.
// 이를 entity클래스에서 사용하지 않는 이유는 각 entity 클래스에서 개별적으로 선언할 필요가 없기 때문이다.
@SpringBootApplication
public class MyBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBlogApplication.class, args);
    }

}
