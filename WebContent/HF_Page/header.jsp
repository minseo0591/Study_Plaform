<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>헤더</title>
    <link rel="icon" href="/Study_Platform/img/KJH_logo_icon.png" />
    <!-- <script
      src="https://kit.fontawesome.com/0bca6ce86d.js"
      crossorigin="anonymous"
    ></script> -->
    <link rel="stylesheet" href="/Study_Platform/HF_Page/header.css" />
	<script src="https://kit.fontawesome.com/a02dac704e.js" crossorigin="anonymous"></script>
   <%//1.한글처리, 파라미터 
request.setCharacterEncoding("UTF-8");
String id = (String) session.getAttribute("id");//object를 string으로 다운캐스팅
%>
</head>
<body>
      <header>
      <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container">
            <div class="navbar-logo">
                <a href="./lectureListController.lc"><img src="/Study_Platform/img/KJH_logo.png"></a>
              </div>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              
              <li class="nav-item me-lg-3"id="tt">
                <a class="nav-link" href="./lectureListController.lc">강의</a>
              </li>

             <!--  <li class="nav-item me-lg-3" id="tt">
                <a class="nav-link" href="#">로드맵</a>
              </li> -->

              <li class="nav-item me-lg-3" id="tt">
                <a class="nav-link" href="./communityListController.bo">커뮤니티</a>
              </li>
              
              <li class="nav-item " id="tt">
                <a class="nav-link" href="./noticeListController.nc?page=1">공지사항</a>
              </li>
           
             <!--  <form class="d-flex me-lg-3">
                <input class="form-control me-2" type="search" aria-label="Search">
                <button class="btn btn-outline-dark" type="submit"><i class="fas fa-search"></i></button>
              </form> -->
              
              <li class="nav-item me-lg-2" id="recent-lecture">
                <!-- <a href="#" class="btn">
                  <i class="fas fa-pencil-alt"></i>
                  <span>최근강의</span>
                </a> -->
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              </li>
             
              <li class="nav-item me-lg-3" id="recent-lecture">
                <!-- <a href="#" class="btn">
                  <i class="fas fa-chalkboard"></i>
                  <span>강의자 신청</span>
                </a> -->
              </li>
            
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="fas fa-user"></i>
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="./MyPageController.lc"><i class="fas fa-house-user"></i>&nbsp;마이페이지</a></li>
                  <!-- <li><a class="dropdown-item" href="#"><i class="fas fa-book"></i>&nbsp;내 강의실</a></li> -->
                  <!-- <li><a class="dropdown-item" href="#"><i class="fas fa-bookmark"></i>&nbsp;북마크</a></li> -->
                  <c:if test="${id eq 'Bashu' }">
                  <li><a class="dropdown-item" href="./ClassAdd.lc"><i class="fa-solid fa-gears"></i>&nbsp;관리자 모드</a></li>
                  </c:if>
                  <li><a class="dropdown-item" href="./MemberJoin.me"><i class="fas fa-user-plus"></i>&nbsp;회원가입</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <c:if test="${id eq null}">
                  <li><a class="dropdown-item" href="./MemberLogin.me"><i class="fas fa-sign-in-alt"></i>&nbsp;로그인</a></li>
                  </c:if>
                  <c:if test="${id != null}">
                  <li><a class="dropdown-item" href="./MemberLogout.me"><i class="fas fa-sign-out-alt"></i>&nbsp;로그아웃</a></li>
                  </c:if>
                </ul>
              </li>
			
            </ul>
          </div>
        </div>
      </nav>
    </header>

    <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script> -->
</body>
</html>