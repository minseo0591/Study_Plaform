<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script> 
<link rel="stylesheet" href="/Study_Platform/Notice/NoticeList/Notice.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="/HF_Page/header.jsp"/>
	<div class="outer">
		<div class="wrap">
			<div class="board_area">
				<div class="board_title">
					<h1>공지사항</h1>
				</div>
				<div class="board_list">
					<ul class="board_header">
						<li class="id">글번호</li>
						<li class="title">제목</li>
						<li class="writer">작성자</li>
						<li class="date">작성일</li>
					</ul>
				
				 <c:forEach var="notice" items="${nolist}"> 
				<ul class="board_ul" onclick="location.href='./noticeDetailController.nc?no_id=${notice.no_id}';">
					<li class="id">${notice.no_id }</li>
					<li class="title">${notice.no_title }</li>
					<li class="writer">${notice.admin_id }</li>
					<li class="date">${notice.no_date}</li>
				</ul>
				</c:forEach>

			</div>
			

			<ul class="board_paging">
			

				
				<!-- 이전 페이지로 -->
				<c:choose>
				<c:when test="${startpage<=1 }">
				</c:when>
				<c:otherwise>
				<li>
						<a href="./noticeListController.nc?page=${startpage-10}">&lt;</a>
				</li>
				</c:otherwise>
				</c:choose>
				
				<c:if test="${startpage <=endpage }">
				<c:forEach var="i" begin="${startpage}" end="${endpage}">
				
					
					<li>
						<a href="./noticeListController.nc?page=${i}" class=current_page>${i}</a>
					</li>
<%-- 					<li>
						<a href="#" class=current_page>2</a>
					</li>
					<li>
						<a href="#" class=current_page>3</a>
					</li>
					<li>
						<a href="#" class=current_page>4</a>
					</li>
					<li>
						<a href="#" class=current_page>5</a>
					</li> --%>
				</c:forEach>
				</c:if>
				<!-- 다음페이지로 -->
				<c:choose>
				<c:when test="${startpage+9>= maxpage }">
				</c:when>
				<c:otherwise>
				<li>
						<a href="./noticeListController.nc?page=${startpage+10}">&gt;</a>
				</li>
				</c:otherwise>
				</c:choose>


			</ul>
			
			
			<div class="search_area">
				<form action="./noticeSearchController.nc?page=${page}&keyWord=${keyWord}&searchWord=${searchWord}" method="get">
					<select id="searchCondition" name="keyWord">
						<option value="no_title">제목</option>
						<option value="no_content">내용</option>
					</select>
					<span class="input_area"> 
						<input type="search" name="searchWord">
					</span>
					<button type="submit">검색하기</button>
						<c:if test="${id eq 'Bashu'}">
                        <button type="button" onclick="location.href='./NoticeAdd.nc'">작성하기</button>
                        </c:if>
				</form>
			</div>
		</div>
	</div>
	</div>
	<jsp:include page="/HF_Page/footer.jsp"/>
	<script>
	const board_ul = document.querySelector('.board_list');
	board_ul.addEventListener('mouseover', function(){
		if(event.target.classList.contains("board_ul")){
			event.target.classList.add('onmouseover');
		}else if(event.target.parentNode.classList.contains('board_ul')){
			event.target.parentNode.classList.add('onmouseover');
		}
	})
	
	board_ul.addEventListener('mouseout', function(){
		if(event.target.classList.contains("board_ul")){
			event.target.classList.remove('onmouseover');
		}else if(event.target.parentNode.classList.contains('board_ul')){
			event.target.parentNode.classList.remove('onmouseover');
		}
	})
	
	function detailView(bid){
		location.href = '${contextPath}/board/detailView?bid=' + bid;
	}
	
	</script>
</body>
</html>