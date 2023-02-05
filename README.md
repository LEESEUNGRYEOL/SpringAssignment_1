# SpringAssignment_1

스프링 1주차 개인과제

## 요구사항

1. 전체 게시글 목록 조회 API
    - 제목, 작성자명, 작성 내용, 작성 날짜를 조회하기
    - 작성 날짜 기준 내림차순으로 정렬하기
2. 게시글 작성 API
    - 제목, 작성자명, 비밀번호, 작성 내용을 저장하고
    - 저장된 게시글을 Client 로 반환하기
3. 선택한 게시글 조회 API
    - 선택한 게시글의 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기
      (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)
4. 선택한 게시글 수정 API
    - 수정을 요청할 때 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    - 제목, 작성자명, 작성 내용을 수정하고 수정된 게시글을 Client 로 반환하기
5. 선택한 게시글 삭제 API
    - 삭제를 요청할 때 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    - 선택한 게시글을 삭제하고 Client 로 성공했다는 표시 반환하기

## API 명세표

| Method | URL            | Request                                                                                                  | Response                                                                                                                                                                                                                                                                                                              |
|--------|----------------|----------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| GET    | /api/blogs    | -                                                                                                        | {{ "createdAt": "2022-07-25T12:43:01.226062”,"modifiedAt": "2022-07-25T12:43:01.226062”,"id": 1,"title": "title2","content": "content2","author": "author2"},{"createdAt": "2022-07-25T12:43:01.226062”,"modifiedAt": "2022-07-25T12:43:01.226062”,"id": 2,"title": "title","content": "content","author": "author"}} |
| GET    | /api/blogs/{id} | -                                                                                                        | {"createdAt": "2022-07-25T12:43:01.226062”,"modifiedAt": "2022-07-25T12:43:01.226062”,"id": 1,"title": "title2","content": "content2","author": "author2"}                                                                                                                                                            |
| POST   | /api/blogs     | {"title" : "title"   ,     "content" : "content",        "author" : "author",  "password": "password"  } | {"createdAt": "2022-07-25T12:43:01.226062”,"modifiedAt": "2022-07-25T12:43:01.226062”,"id": 1,"title": "title","content": "content","author": "author"}                                                                                                                                                               |
| PUT    | /api/blogs/{id} | {"title" : "title"   ,     "content" : "content",        "author" : "author",  "password": "password"  }| {"createdAt": "2022-07-25T12:43:01.226062”,"modifiedAt": "2022-07-25T12:43:01.226062”,"id": 1,"title": "title2","content": "content2","author": "author2"}                                                                                                                                                            |
| DELETE | /api/blogs/{id} | {"title" : "title"   ,     "content" : "content",        "author" : "author",  "password": "password"  }                                                                           | {"message": "성공" }                                                                                                                                                                                                                                                                                                    |



## 질문사항
#### 1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)

- 수정및 삭제 API 에서는 param 방식으로 request를 받아서 사용했습니다.
#### 2. 어떤 상황에 어떤 방식의 request를 써야하나요?

- GET : GET Method 와 같은 경우에는 보통 받아오는 경우 사용이 됨으로, 만약 특정 값을 가져오려면 Request body 부분은 비워두는 param 방식을 사용해야 할 것 같습니다.
- POST: Request body에 보내주고 싶은 정보를, 즉 등록하고 싶은 정보를 넣어서 보내주는 경우에 사용합니다. 이떄 본 과제와 같은 경우는 잘 저장되었다는 것을 알려주기 위해서 등록정보를 Response 로 보내주었습니다.
- PUT: Param을 통해서 특정 id 값에 대한 수정 정보를 request body 에 넣어서 보내주는 부분입니다.
- DELETE : Param을 통해서 특정 id 값에 대한 삭제를 request body 에 넣어서 보내주었습니다.


#### 3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?

- GET, POST,  DELETE,PUT 전부 설계했으므로, 잘 설계한 RESTful 한 API 인 것 같다.
#### 4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)

- 잘 분리해서 적용을 하였다. Controller 부분 (view 와 server 간의 소통), Repo(데이터) 부분 , service 부분 (method) 을 잘 나누어서 작업했고
- 이를 client에게 전달할때도 DTO를 통해서 잘 전달하는 작업을 진행하였다.

#### 5. API 명세서 작성 가이드라인을 검색하여 직접 작성한 API 명세서와 비교해보세요!


## 진행상황

- 22.02.05 : DELETE 까지 작성은 완료했지만, 조금 찜찜한 부분이 많다. 특히나 DELETE 부분에서 새로운 DTO를 만들어야 하는 것 때문에 시간이 걸렸는데, 만약 원래 문제의도대로 한다면 requestDTO도 삭제 부분에서는 새로 만들어야 하는가?