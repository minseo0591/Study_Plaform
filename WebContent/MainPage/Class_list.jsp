<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="test.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    <title>강의</title>
    <link rel="stylesheet" href="test3.css">

</head>
<body>
  <jsp:include page="/HF_Page/header.jsp"/>
    <div class="container">
        <div class="row">
         
            <div class="col-lg-3"  style=" max-width: 240px;">
                <div class="accordion" id="accordionPanelsStayOpenExample">

                  <div class="accordion-item">
                    <button type="button" class="btn" style="width:214px; height:52px; text-align: left; padding:16px 20px;" onclick="location.href='./lectureListController.lc?page=${startpage}';">전체 목록</button>
                  </div>
                  
                  <div class="accordion-item">
                      <h2 class="accordion-header" id="headingOne">
                      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="false" aria-controls="panelsStayOpen-collapseOne">
                          개발 &#8226; 프로그래밍
                        </button>
                      </h2>
         
                      <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse" aria-labelledby="panelsStayOpen-headingOne">
                        <ul class="list-group list-group-flush">
                          <li class="list-group-item list-group-item-action" name="category" onclick="location.href='./lectureCategoryController.lc?category=프로그래밍';" style="cursor:pointer">프로그래밍</li>
                          <li class="list-group-item list-group-item-action" name="category" onclick="location.href='./lectureCategoryController.lc?category=HTML';" style="cursor:pointer">HTML</li>
                          <li class="list-group-item list-group-item-action" name="category" onclick="location.href='./lectureCategoryController.lc?category=CSS';" style="cursor:pointer">CSS</li>
                          <li class="list-group-item list-group-item-action" name="category" onclick="location.href='./lectureCategoryController.lc?category=자바스크립트';" style="cursor:pointer">자바스크립트</li>
                        </ul>
                      </div>
                      
                    </div>

                    <div class="accordion-item">
                      <h2 class="accordion-header" id="headingTwo">
                      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false" aria-controls="panelsStayOpen-collapseTwo">
                          교과목
                        </button>
                      </h2>
         
                      <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse" aria-labelledby="panelsStayOpen-headingTwo">
                        <ul class="list-group list-group-flush">
                          <li class="list-group-item list-group-item-action" name="category" onclick="location.href='./lectureCategoryController.lc?category=국어';" style="cursor:pointer">국어</li>
                          <li class="list-group-item list-group-item-action" name="category" onclick="location.href='./lectureCategoryController.lc?category=수학';" style="cursor:pointer">수학</li>
                          <li class="list-group-item list-group-item-action" name="category" onclick="location.href='./lectureCategoryController.lc?category=영어';" style="cursor:pointer">영어</li>
                          <li class="list-group-item list-group-item-action" name="category" onclick="location.href='./lectureCategoryController.lc?category=사회';" style="cursor:pointer">사회</li>
                        </ul>
                      </div>
                      
                    </div>
                    
                    <div class="accordion-item">
                      <h2 class="accordion-header" id="headingThree">
                      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="false" aria-controls="panelsStayOpen-collapseThree">
                          외국어
                        </button>
                      </h2>
         
                      <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse" aria-labelledby="panelsStayOpen-headingThree">
                        <ul class="list-group list-group-flush">
                          <li class="list-group-item  list-group-item-action" name="category" onclick="location.href='./lectureCategoryController.lc?category=일본어';" style="cursor:pointer">일본어</li>
                          <li class="list-group-item list-group-item-action" name="category"  onclick="location.href='./lectureCategoryController.lc?category=중국어';" style="cursor:pointer">중국어</li>
                          <li class="list-group-item list-group-item-action" name="category"  onclick="location.href='./lectureCategoryController.lc?category=영어회화';" style="cursor:pointer">영어회화</li>
                          <li class="list-group-item list-group-item-action" name="category" onclick="location.href='./lectureCategoryController.lc?category=스페인어';" style="cursor:pointer">스페인어</li>
                        </ul>
                      </div>
                      
                    </div>
                    
                    <div class="accordion-item">
                      <h2 class="accordion-header" id="headingFour">
                      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseFour" aria-expanded="false" aria-controls="panelsStayOpen-collapseFour">
                          교육
                        </button>
                      </h2>
         
                      <div id="panelsStayOpen-collapseFour" class="accordion-collapse collapse" aria-labelledby="panelsStayOpen-headingFour">
                        <ul class="list-group list-group-flush">
                          <li class="list-group-item  list-group-item-action" name="category" onclick="location.href='./lectureCategoryController.lc?category=다문화 교육';" style="cursor:pointer">다문화교육</li>
                        </ul>
                      </div>
                      
                    </div>
                   
                   
                  </div>
            </div>

          <div class="col" style="margin-right: 10px; min-height: 818px;">
            <div class="row py-2">
                <!-- <div class="col">
                  <div>
                    <input class="form-control" type="text" placeholder="Default input">
                    <div class="btn btn-primary mb-1">검색</div>
                  </div>

                </div> -->
                <div class="col-lg-8"></div>
                <form action="./lectureSearchController.lc?page=${page}&keyWord=${keyWord}&searchWord=${searchWord}" method="get">
                <div class="input-group col-lg-4 mt-2" style="width:350px">
                  <select name="keyWord">
                  	<option value="lec_title">제목</option>
                  	<option value="lec_lecturer">강의자</option>
                  </select>
                  <input type="text" class=" form-control" name="searchWord">
                  <span class="input-group-btn">
                       <button class="btn btn-primary" type="submit">검색</button>
                  </span>
               </div>
               </form>
            </div>

            <div>
            <hr style="margin:5px 0px;">
            <div style="font-weight:bold; font-size:20px;">전체</div>
           
         <!--    <select class="form-select form-select-sm mt-2" style="width: 100px;" aria-label=".form-select-sm example">
              <option selected>정렬</option>
              <option value="1">인기순</option>
              <option value="2">최신순</option>
              <option value="3">조회순</option>
            </select> -->
            </div>
            <div class="row" style="margin-top:10px;">
                <!--강의 내용-->
                <c:forEach items="${classlist}" var="list">
                <div class="card-back mb-2" style="width: 230px; cursor:pointer;" onclick="location.href='./lectureDetailController.lc?lec_id=${list.lec_id}';">
                	<c:set var="img" value="/img/"/>
                	<c:choose>
                	<c:when test="${list.lec_thum ne img}">
                    <div class="card-img">
                    <img src="${list.lec_thum}" style="width: 230px; height:150px;a">
                    </div>
                    </c:when>
                    <c:when test="${list.lec_thum eq img}">
                    <img src="/Study_Platform/img/imgnull.jpg" style="width: 230px; height:150px;a">
                    </c:when>
                    </c:choose>
                    <%-- <div class="card-id"><span class="text-muted">${list.lec_id}</span></div> --%>
                    <div class="card-title"><div class="fw-bold">${list.lec_title}</div></div>
                    <div class="card-teacher"><span class="text-muted">${list.lec_lecturer}</span></div>
                    <div class="card-rating">
                    	<c:choose>
                    	<c:when test="${list.lec_staravg / list.lec_replynum >= 5 }">
                    	<div class="rating-stars" style="color:#ffD700">
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                    	</div>
                    	</c:when>
                    	<c:when test="${list.lec_staravg / list.lec_replynum >= 4}">
                    	<div class="rating-stars" style="color:#ffD700">
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                    	</div>
                    	</c:when>
                    	<c:when test="${list.lec_staravg / list.lec_replynum >= 3}">
                    	<div class="rating-stars" style="color:#ffD700">
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                    	</div>
                    	</c:when>
                    	<c:when test="${list.lec_staravg / list.lec_replynum >= 2}">
                    	<div class="rating-stars" style="color:#ffD700">
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                    	</div>
                    	</c:when>
                    	<c:when test="${list.lec_staravg / list.lec_replynum >= 1}">
                    	<div class="rating-stars" style="color:#ffD700">
                              <svg aria-hidden="true" data-prefix="fas" data-icon="star" class="svg-inline--fa fa-star fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" width="16" height="16" data-value="1"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z"></path></svg>
                    	</div>
                    	</c:when>
                    	</c:choose>
                    </div>
                    <div class="card-under"><span class="badge bg-secondary text-white" style="margin-top:10px;">+ ${list.lec_replynum} 수강평</span></div>
                </div>
                </c:forEach>

        
          <ul class="pagination mt-2" style="justify-content : center;">
         
            <c:choose>
			<c:when test="${startpage <= 1}">
            </c:when>
            <c:otherwise>
            <li class="page-item"><a class="page-link" href="./lectureListController.lc?page=${startpage-10}">이전</a></li>
            </c:otherwise>
            </c:choose>
            
             <c:if test="${startpage <= endpage}">
	         <c:forEach var="i" begin="${startpage}" end="${endpage}">
	         	<c:choose>
	         	<c:when test="${searchWord eq null && keyWord eq null && category eq null}">
	            <li class="page-item"><a class="page-link" href="./lectureListController.lc?page=${i}">${i}</a></li>
	            </c:when>
	            <c:when test="${category ne null}">
	            <li class="page-item"><a class="page-link" href="./lectureCategoryController.lc?page=${i}&category=${category}">${i}</a></li>
	            </c:when>
	            <c:otherwise>
	            <li class="page-item"><a class="page-link" href="./lectureSearchController.lc?page=${i}&keyWord=${keyWord}&searchWord=${searchWord}">${i}</a></li>
	            </c:otherwise>
	            </c:choose>
	         </c:forEach>
	         </c:if>
          
          	<c:choose>
            <c:when test="${startpage+9 >= maxpage}">
            </c:when>
            <c:otherwise>
            <li class="page-item"><a class="page-link" href="./lectureListController.lc?page=${startpage+10}">다음</a></li>
            </c:otherwise>
            </c:choose>
            
          </ul>
       
        
            </div>

          </div>
        </div>
        <div class="col-lg-1">

        </div>
      <!--컨테이너종료-->
      </div>
      <jsp:include page="/HF_Page/footer.jsp"/>
    

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>