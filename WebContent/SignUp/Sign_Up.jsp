<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
   
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script> 
    <link rel="icon" href="/Study_Platform/SignUp/img/KJH_logo_icon.png" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css"/>
    <link rel="stylesheet"href="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.css"/>
    <link rel="stylesheet" href="/Study_Platform/SignUp/css/signup.css" />
    <link rel="stylesheet" href="/Study_Platform/SignUp/css/signup_com.css" />
    <script src="https://kit.fontawesome.com/0bca6ce86d.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
    <jsp:include page="/HF_Page/header.jsp"/>
      <main>
        <section class="signup">
          <h2 class="signup-title">회원가입</h2>
  
          <div class="signup-messages">
            <div class="swiper-container">
              <div class="swiper-wrapper">
                <div class="swiper-slide">
                  <p>나의 온라인 사수, 공프런</p>
                </div>
                <div class="swiper-slide">
                  <p>나의 성장을 돕는 IT 실무 지식 플랫폼</p>
                </div>
  
                <div class="swiper-slide">
                  <p>공프런에서 가치를 높이세요</p>
                </div>
                <div class="swiper-slide">
                  <p>나의 성장을 돕는 IT 실무 지식 플랫폼</p>
                </div>
              </div>
            </div>
          </div>
  
          <div class="signup-main">
            <form class="signup-form" method="post" action="./MemberJoinController.me">
              <div class="form-input">
                <label for="email" class="form-label" for="validationDefault01">아이디</label>
                <input id="email" name="stu_id" type="text" placeholder="example" id="validationDefault01" required/>
              </div>
  
             <!--  <div class="form-input">
                <label for="email-confirm" class="form-label">아이디 확인</label>
                <input
                  id="email-confirm"
                  name="email-confirm"
                  type="text"
                  placeholder="example"
                />
              </div> -->
  
              <div class="signup-main">
                  <div class="form-input">
                    <label for="name" class="form-label" for="validationDefault02">이름</label>
                    <input id="name" name="stu_name" type="text" placeholder="홍길동" id="validationDefault02" required/>
                  </div>
  
              <div class="form-input">
                <label for="password" class="form-label" for="validationDefault03">비밀번호</label>
                <div class="password-input">
                  <input name="stu_pwd" type="password" placeholder="******" id="validationDefault03" required/>
                  <span class="password-eye">
                    <svg
                      width="16"
                      height="16"
                      xmlns="http://www.w3.org/2000/svg"
                      viewBox="0 0 16 16"
                    >
                      <path
                        fill="#212529"
                        d="M10.333 8c0 1.289-1.044 2.333-2.333 2.333C6.71 10.333 5.667 9.29 5.667 8 5.667 6.711 6.71 5.667 8 5.667c1.289 0 2.333 1.044 2.333 2.333z"
                      ></path>
                      <path
                        fill="#212529"
                        fill-rule="evenodd"
                        d="M8 2.333c-2.288 0-4.083 1.023-5.37 2.16C1.348 5.63.544 6.902.22 7.469.03 7.8.03 8.2.22 8.533c.323.566 1.127 1.838 2.41 2.973 1.287 1.138 3.082 2.16 5.37 2.16 2.288 0 4.083-1.022 5.37-2.16 1.283-1.135 2.087-2.407 2.41-2.973.19-.333.19-.733 0-1.065-.323-.567-1.127-1.839-2.41-2.974-1.287-1.138-3.082-2.16-5.37-2.16zm-6.912 5.63c.295-.516 1.035-1.685 2.205-2.72C4.461 4.21 6.03 3.333 8 3.333c1.97 0 3.54.877 4.707 1.91 1.17 1.035 1.91 2.204 2.205 2.72.008.015.01.028.01.037 0 .01-.002.022-.01.037-.295.516-1.035 1.685-2.205 2.72-1.168 1.033-2.737 1.91-4.707 1.91-1.97 0-3.54-.877-4.707-1.91-1.17-1.035-1.91-2.204-2.205-2.72-.008-.015-.01-.028-.01-.037 0-.01.002-.022.01-.037z"
                        clip-rule="evenodd"
                      ></path>
                    </svg>
                  </span>
                </div>
              </div>
  
              <!-- <div class="form-input">
                <label for="password-confirm" class="form-label"
                  >비밀번호 확인</label
                >
                <div class="password-input">
                  <input id="password-confirm" name="password-confirm" type="password" placeholder="******" />
                  <span class="password-eye">
                    <svg
                      width="16"
                      height="16"
                      xmlns="http://www.w3.org/2000/svg"
                      viewBox="0 0 16 16"
                    >
                      <path
                        fill="#212529"
                        d="M10.333 8c0 1.289-1.044 2.333-2.333 2.333C6.71 10.333 5.667 9.29 5.667 8 5.667 6.711 6.71 5.667 8 5.667c1.289 0 2.333 1.044 2.333 2.333z"
                      ></path>
                      <path
                        fill="#212529"
                        fill-rule="evenodd"
                        d="M8 2.333c-2.288 0-4.083 1.023-5.37 2.16C1.348 5.63.544 6.902.22 7.469.03 7.8.03 8.2.22 8.533c.323.566 1.127 1.838 2.41 2.973 1.287 1.138 3.082 2.16 5.37 2.16 2.288 0 4.083-1.022 5.37-2.16 1.283-1.135 2.087-2.407 2.41-2.973.19-.333.19-.733 0-1.065-.323-.567-1.127-1.839-2.41-2.974-1.287-1.138-3.082-2.16-5.37-2.16zm-6.912 5.63c.295-.516 1.035-1.685 2.205-2.72C4.461 4.21 6.03 3.333 8 3.333c1.97 0 3.54.877 4.707 1.91 1.17 1.035 1.91 2.204 2.205 2.72.008.015.01.028.01.037 0 .01-.002.022-.01.037-.295.516-1.035 1.685-2.205 2.72-1.168 1.033-2.737 1.91-4.707 1.91-1.97 0-3.54-.877-4.707-1.91-1.17-1.035-1.91-2.204-2.205-2.72-.008-.015-.01-.028-.01-.037 0-.01.002-.022.01-.037z"
                        clip-rule="evenodd"
                      ></path>
                    </svg>
                  </span>
                </div>
              </div> -->
  
              <div class="form-input">
                <input type="radio" name="classType" value="고객" checked>고객
                <!-- <input type="radio" name="classType" value="관리자">관리자
               
                <input id="test" type="text" placeholder="관리자 권한 코드"/> -->
               
              </div>
  
  
            <input type="submit" class="btn" value="가입하기"> <!-- onclick="location.href='/Study_Platform/MainPage/Class_list.jsp';" -->
            </form>
        
          </div>
        </section>
      </main>
		<jsp:include page="/HF_Page/footer.jsp"/>

    
  <script src="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.js"></script>
    <script src="/Study_Platform/SignUp/js/signup.js"></script>
    <script src="/Study_Platform/SignUp/test.js"></script>
</body>
</html>