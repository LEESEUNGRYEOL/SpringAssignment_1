# SpringAssignment_1

스프링 1주차 개인과제
## Use-case
![IMG_37B3F5BF801E-1](https://user-images.githubusercontent.com/96409909/216916410-da692ffe-7531-487b-9b45-584e6543d4df.jpeg)

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
| PUT    | /api/blogs/{id} | {  "content" : "content",    "password": "password"  } | {"createdAt": "2022-07-25T12:43:01.226062”,"modifiedAt": "2022-07-25T12:43:01.226062”,"id": 1,"title": "title2","content": "content2","author": "author2"}                                                                                                                                                            |
| DELETE | /api/blogs/{id} | {"password": "password"  }                                                                               | {"message": "성공" }                                                                                                                                                                                                                                                                                                    |



## 질문사항
#### 1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)

- 수정및 삭제 API 에서는 param 방식으로 id를 받아서 사용했으며, 제목과 내용 비밀번호 등과 같은 내용은 RequestBody에서 Json 형식으로 받아서 사용했습니다.
#### 2. 어떤 상황에 어떤 방식의 request를 써야하나요?

- GET : GET Method 와 같은 경우에는 보통 받아오는 경우 사용이 됨으로, 만약 특정 값을 가져오려면 Request body 부분은 비워두는 param 방식을 사용해야 할 것 같습니다.
- POST: Request body에 보내주고 싶은 정보를, 즉 등록하고 싶은 정보를 넣어서 보내주는 경우에 사용합니다. 이떄 본 과제와 같은 경우는 잘 저장되었다는 것을 알려주기 위해서 등록정보를 Response 로 보내주었습니다.
- PUT: Param을 통해서 특정 id 값에 대한 수정 정보를 request body 에 넣어서 보내주는 부분입니다.
- DELETE : Param을 통해서 특정 id 값에 대한 삭제를 request body 에 넣어서 보내주었습니다.


#### 3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?

- GET, POST, DELETE, PUT 전부 설계했으므로, 잘 설계한 RESTful 한 API 인 것 같습니다.
#### 4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)

- 잘 분리해서 적용을 하였다. Controller 부분 (view 와 server 간의 소통), Repo(데이터) 부분 , service 부분 (method) 을 잘 나누어서 작업했고
- 이를 client에게 전달할때도 DTO를 통해서 잘 전달하는 작업을 진행하였습니다.

#### 5. API 명세서 작성 가이드라인을 검색하여 직접 작성한 API 명세서와 비교해보세요!

- 비교완료 하였습니다.

## 실행결과
#### [POST 결과]
<img width="1184" alt="스크린샷 2023-02-06 오후 3 19 58" src="https://user-images.githubusercontent.com/96409909/216916606-cd3daa49-5960-4d0d-88b8-0a90d54c561e.png">
<img width="666" alt="스크린샷 2023-02-06 오후 3 20 41" src="https://user-images.githubusercontent.com/96409909/216916499-de31cc7a-ef51-45a3-af61-60342a0259f0.png">

#### [GET 결과]
<img width="1181" alt="스크린샷 2023-02-06 오후 3 21 16" src="https://user-images.githubusercontent.com/96409909/216916930-9032ffdb-3ee3-461f-8f50-90fb8ed2035f.png">
<img width="1185" alt="스크린샷 2023-02-06 오후 3 21 32" src="https://user-images.githubusercontent.com/96409909/216916879-fcb58f56-2f22-43e2-a08e-cdbd2373b0de.png">

#### [PUT 결과]
<img width="1185" alt="스크린샷 2023-02-06 오후 3 22 05" src="https://user-images.githubusercontent.com/96409909/216916839-96240e29-3746-4526-9f2d-6078192e6cb0.png">

#### [DELETE 결과]
<img width="1185" alt="스크린샷 2023-02-06 오후 3 22 39" src="https://user-images.githubusercontent.com/96409909/216916745-6a660ccb-564f-4a29-bce7-43f2f582339c.png">

#### [총 진행 결과 DB]
<img width="693" alt="스크린샷 2023-02-06 오후 3 23 02" src="https://user-images.githubusercontent.com/96409909/216916655-98a72b88-f70c-4628-87e0-8f0d83fd7481.png">





## 진행상황

- 23.02.05 : DELETE 까지 작성은 완료했지만, 조금 찜찜한 부분이 많다. 특히나 DELETE 부분에서 새로운 DTO를 만들어야 하는 것 때문에 시간이 걸렸는데, 만약 원래 문제의도대로 한다면 requestDTO도 삭제 부분에서는 새로 만들어야 하는가?
- 23.02.06 : 일단 requestDto 에서 보내주는 내용 (ReqeustBody) 에서의 수정부분이 있었다. 위의 고민했던 내용들은 사실상 Blog entity 에서의 메서드에서의 오류만 잘 해결하면 해결되는 문제였다. 이제는 다른 request 형식으로 바꿔서 받아보는 연습을 해봐야겠다.