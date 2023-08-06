<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <%//1.한글처리, 파라미터 
request.setCharacterEncoding("UTF-8");
String id = (String) session.getAttribute("id");//object를 string으로 다운캐스팅
//1-1. id없이는 진입불가, id없는 경우 로그인페이지로 이동. 가상주소로 이동
if(id == null){
	out.println("<script>alert('로그인을 해주세요!');</script>");
	/* response.sendRedirect("./MemberLogin.me"); */
	out.println("<script>location.href='./MemberLogin.me';</script>");
}
%>
	
    
    <title>대시보드</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/jumbotron/">

    

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/style.css" />
    <link rel="stylesheet" href="./css/jquery.rprogessbar.min.css">
    <!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/5.0/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.0/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.0/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
  </head>
  
 <body>
   
<main>
  <jsp:include page="/HF_Page/header.jsp"/>
  <div class="container py-4">
    <title>회원 대시보드</title>
    <span class="fs-4 fw-bold">대시보드</span>
    <hr>

    <div class="row align-items-md-stretch">
      <div class="col-md-5">
        <div class="h-100 p-3 bg-light rounded-3">
            <div>
          <h4 class="mar-r">😀 <%=	id %>님의 프로필</h4>
          </div>
          <!-- <div class="mar-b1">
        <button class="btn btn-outline-success"data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo" type="button">수정하기</button></div> -->
          <p><%=id %>님, 안녕하세요! 👋🏼</p>
        </div>
      </div>

      <div class="col-md-5">
        <div class="h-100 p-3 bg-light border rounded-3">
          <h4>📖 마지막 수강신청 강의</h4>
          <p>: ${last_title}</p>
          <p>${last_date }일 수강하셨습니다.</p>
          <!-- <p style="font-size: 13px;">진도율: 100강/75강 (75.00%)</p> -->
          <div class="single-progressbar">
            <h4 class="title"></h4>
            <div class="class"></div>
            </div>
          <button class="btn btn-outline-success" type="button" onclick="location.href='./Vmap.lc?lec_id=${last_lecid}&&level=1';">이어서 학습하기</button>
        </div>
      </div>

      <div>&nbsp;</div>

      <div class="col-md-5">
        <div class="h-100 p-3 bg-light border rounded-3">
          <h4>🏃🏻 학습 통계</h4>
          <div class="d-flex justify-content-center" style="margin-top: 25px;">
          <div style="padding-right:70px;">
            <h3><p class="fw-bolder text-center">${mydonecount }</p></h3>
            <p class="text-center fw-light">완료한 강의 수</p>
          </div>
          <div class="mar">
            <h3><p class="fw-bolder text-center">${mysugangcount }</p></h3>
            <p class="text-center fw-light">수강 강의 수</p>
          </div>
          <div style="padding-left:70px;">
            <h3><p class="fw-bolder text-center">${mycommentcount }</p></h3>
            <p class="text-center fw-light">강의 리뷰수</p>
          </div>
        </div>
        </div>
      </div>
      
      <div class="col-md-5">
        <div class="h-100 p-3 bg-light border rounded-3">
            <div>
          <h4 class="mar-r">📚 수강신청한 강의</h4>
            </div>
            <div class="mar-b">
                <button class="btn btn-outline-success" type="button" onclick="location.href='./Main.me';">전체 보기</button>
            </div>
            <div class="d-flex">
                <ul>
                <c:forEach items="${sugangarray }" var="aa">
                    <li class="mar-b-6"><a href="./Vmap.lc?lec_id=${aa.lec_id}&&level=1">${aa.lec_title }</a> <span class="mar2 fw-light">${aa.su_date }</span></li>
               </c:forEach>
                </ul>
            </div>
        </div>
      </div>
      
      <div>&nbsp;</div>
      <div>&nbsp;</div>
      <div>&nbsp;</div>
      <div>&nbsp;</div>
      <div>&nbsp;</div>
      <div>&nbsp;</div>
      <div>&nbsp;</div>
      <div>&nbsp;</div>
      <div>&nbsp;</div>
      <div>&nbsp;</div>
      

    <!--  <div class="col-md-5">
        <div class="h-100 p-3 bg-light border rounded-3">
            <div>
          <h4 class="mar-r">📝 최근 작성한 게시글</h4>
            </div>
            <div class="mar-b1">
                <button class="btn btn-outline-success" type="button" onclick="location.href='/Study_Platform/Board/Board_Search/Board_Search.jsp';">전체 보기</button>
            </div>
            <div class="d-flex">
                <ul>
                    <li class="mar-b-6">이건테스트입니다. <span class="mar2 fw-light">7일 전</span></li>
                    <li class="mar-b-6">이건테스트입니다. <span class="mar2 fw-light">7일 전</span></li>
                    <li class="mar-b-6">이건테스트입니다. <span class="mar2 fw-light">7일 전</span></li>
                    <li class="mar-b-6">이건테스트입니다. <span class="mar2 fw-light">7일 전</span></li>
                    <li class="mar-b-6">이건테스트입니다. <span class="mar2 fw-light">7일 전</span></li>
                </ul>
            </div>
        </div>
      </div> -->

    </div>
  </div>
</main>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">회원 수정하기</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form>
            <div class="mb-3">
              <label for="recipient-name" class="col-form-label">아이디</label>
              <input type="text" class="form-control" id="recipient-name">
            </div>

            <div class="mb-3">
                <label for="recipient-password" class="col-form-label">비밀번호</label>
                <input type="text" class="form-control" id="recipient-password">
              </div>

              <div class="mb-3">
                <label for="recipient-password" class="col-form-label">비밀번호 확인</label>
                <input type="text" class="form-control" id="recipient-password">
              </div>

              <div class="mb-3">
                <label for="recipient-name" class="col-form-label">이름</label>
                <input type="text" class="form-control" id="recipient-name">
              </div>

          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary">수정완료</button>
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        </div>
      </div>
    </div>
  </div> 
   <jsp:include page="/HF_Page/footer.jsp"/>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="./js/test.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.6.0/jquery-migrate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/waypoints/4.0.1/jquery.waypoints.js"></script>
    <script src="./js/jQuery.rProgressbar.min.js"></script>
    <script src="./js/active.js"></script>
    
  </body>
</html>
    