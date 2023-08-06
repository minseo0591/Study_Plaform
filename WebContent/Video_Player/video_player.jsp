<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8"/>
	<title>Video Player</title>
	<link href="/Study_Platform/Video_Player/style4.css" rel="stylesheet">
	
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<meta name="viewport" content="initial-scale=1, maximum-scale=1"><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
</head>
<body>
	<section id="skin">
		<input type="checkbox" id="menu" name="menu" class="menu-checkbox">
        <div class="menu">
          <label class="menu-toggle" for="menu"><span>Toggle</span></label>
              <c:forEach items="${videos }" var="aa">
          <ul>
            <li>
                <label><a href="./Vmap.vc?lec_id=${aa.lec_id }&&level=${aa.lec_level }">제목: ${aa.cm_chtitle}</a></label>
            </li>
          </ul>
        </c:forEach>
        </div>

	    <nav>
			<div class="row">
				<div class="col-lg-1">
				</div>
				
				<div class="color1 col-lg-10 fw-bold" style="text-align: center;">${ch_title }</div>
				<div class="col-lg-1">
					<button type="button" class="btn btn-primary" onclick="location.href='./MyPageController.lc';" style="width:120px; margin-left: -25px; margin-bottom: 8px;">내 학습목록</button>
				</div>
			</div>
			<div>
			<jsp:include page="./MovieSrc.jsp" />
			</div>
			<!-- <iframe id="myMovie" width="100%" height="630" src="https://www.youtube.com/3Plu6lw3QOo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe> -->
			<div class="container">
					<ul class="pagination justify-content-center">
                      <li class="page-item">
                      <c:choose>
                       <c:when test="${levels < 2 }">
                       <div onclick="alter('첫째 영상입니다!');">
                        <a class="page-link" href="./Vmap.vc?lec_id=${lec_id}&&level=1" onclick="alert('첫 페이지 입니다!')" aria-label="Previous"> 
                          <span aria-hidden="true">&laquo; 이전 강의</span>
                        </a></div>
                        </c:when>
                        <c:when test="${levels > 1 and levels < maxlevel}">
                        <a class="page-link" href="./Vmap.vc?lec_id=${lec_id}&&level=${levels-1}" aria-label="Previous"> 
                          <span aria-hidden="true">&laquo; 이전 강의</span>
                        </a>
                        </c:when>
                        <c:when test="${levels eq maxlevel }">
                        <a class="page-link" href="./Vmap.vc?lec_id=${lec_id}&&level=${levels-1}" aria-label="Previous"> 
                          <span aria-hidden="true">&laquo; 이전 강의</span>
                        </a>
                        </c:when>
                        </c:choose>
                      </li>
					  
					  <c:choose>
					  <c:when test="${levels < maxlevel }">
					  <li class="page-item"><a class="page-link" href="./Vmap.vc?lec_id=${lec_id}&&level=${levels}">현재 강의</a></li>
					  </c:when>
					  <c:when test="${levels eq maxlevel }">
					  <li class="page-item"><a class="page-link" href="./Vmap.vc?lec_id=${lec_id}&&level=${levels}&&check=1">수강 완료</a></li>
					  </c:when> 
					  </c:choose>
					  
                      <li class="page-item">
                      <c:choose>
                      <c:when test="${levels < maxlevel }">
                        <a class="page-link" href="./Vmap.vc?lec_id=${lec_id }&&level=${levels+1}" aria-label="Next">
                          <span aria-hidden="true">다음 강의 &raquo;</span>
                        </a>
                        </c:when>
                        <c:when test="${levels eq maxlevel }">
                        <a class="page-link" href="./Vmap.vc?lec_id=${lec_id }&&level=${levels }" onclick="alert('마지막 페이지 입니다!')" aria-label="Next">
                          <span aria-hidden="true">다음 강의 &raquo;</span>
                        </a>
                        </c:when>
                        </c:choose>
                      </li>
                    </ul>
			</div>
	    </nav>
</section>

</body>
</html>
	
    