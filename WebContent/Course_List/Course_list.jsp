<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 강의 목록</title>
<link rel="stylesheet" href="/Study_Platform/Course_List/Course.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="/HF_Page/header.jsp"/>
	<div class="outer">
		<div class="wrap">
			<div class="board_area">
				<div class="board_title">
					<h1>내 강의 목록</h1>
				</div>
				<div class="board_list">
					<ul class="board_header">
						<li class="id">강의번호</li>
						<li class="category" style="width: 200px;">카테고리</li>
						<li class="title">제목</li>
						<li class="writer">강의자</li>
						<li class="count">수강수</li>
						<li class="date">강의 시청일</li>
					</ul>
				
				<%-- <c:forEach var="list" items="#"> --%>
				<ul class="board_ul" onclick="#">
					<li class="id">1</li>
					<li class="category" style="width: 200px;">프로그래밍</li>
					<li class="title">강의1</li>
					<li class="writer">공정한</li>
					<li class="count">150</li>
					<li class="date">2022-11-19</li>
				</ul>
				
				<ul class="board_ul" onclick="#">
					<li class="id">2</li>
					<li class="category" style="width: 200px;">프로그래밍</li>
					<li class="title">강의1</li>
					<li class="writer">공정한</li>
					<li class="count">150</li>
					<li class="date">2022-11-19</li>
				</ul>
				
				<ul class="board_ul" onclick="#">
					<li class="id">3</li>
					<li class="category" style="width: 200px;">프로그래밍</li>
					<li class="title">강의1</li>
					<li class="writer">공정한</li>
					<li class="count">150</li>
					<li class="date">2022-11-19</li>
				</ul>
				
				<ul class="board_ul" onclick="#">
					<li class="id">4</li>
					<li class="category" style="width: 200px;">프로그래밍</li>
					<li class="title">강의1</li>
					<li class="writer">공정한</li>
					<li class="count">150</li>
					<li class="date">2022-11-19</li>
				</ul>
				
				<ul class="board_ul" onclick="#">
					<li class="id">5</li>
					<li class="category" style="width: 200px;">프로그래밍</li>
					<li class="title">강의1</li>
					<li class="writer">공정한</li>
					<li class="count">150</li>
					<li class="date">2022-11-19</li>
				</ul>
				
				<ul class="board_ul" onclick="#">
					<li class="id">6</li>
					<li class="category" style="width: 200px;">프로그래밍</li>
					<li class="title">강의1</li>
					<li class="writer">공정한</li>
					<li class="count">150</li>
					<li class="date">2022-11-19</li>
				</ul>
				
				<ul class="board_ul" onclick="#">
					<li class="id">7</li>
					<li class="category" style="width: 200px;">프로그래밍</li>
					<li class="title">강의1</li>
					<li class="writer">공정한</li>
					<li class="count">150</li>
					<li class="date">2022-11-19</li>
				</ul>
				
				<ul class="board_ul" onclick="#">
					<li class="id">8</li>
					<li class="category" style="width: 200px;">프로그래밍</li>
					<li class="title">강의1</li>
					<li class="writer">공정한</li>
					<li class="count">150</li>
					<li class="date">2022-11-19</li>
				</ul>
				
				<ul class="board_ul" onclick="#">
					<li class="id">9</li>
					<li class="category" style="width: 200px;">프로그래밍</li>
					<li class="title">강의1</li>
					<li class="writer">공정한</li>
					<li class="count">150</li>
					<li class="date">2022-11-19</li>
				</ul>
				
				<ul class="board_ul" onclick="#">
					<li class="id">10</li>
					<li class="category" style="width: 200px;">프로그래밍</li>
					<li class="title">강의1</li>
					<li class="writer">공정한</li>
					<li class="count">150</li>
					<li class="date">2022-11-19</li>
				</ul>
				<%-- </c:forEach> --%>
			</div>
			

			<ul class="board_paging">
			
				<!-- 첫페이지로  -->
				<li>
					<a href="#">&lt;&lt;</a>
				</li>
				
				<!-- 이전 페이지로 -->
				<li>
						<a href="#">&lt;</a>
				</li>
				
					<li>
						<a href="#" class=current_page>1</a>
					</li>
					<li>
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
					</li>
				
				<!-- 다음페이지로 -->
				<li>
						<a href="#">&gt;</a>
				</li>
				
				<!-- 끝페이지로  -->
				<li>
					<a href="#">&gt;&gt;</a>
				</li>
			</ul>
			<div class="search_area">
				<form method="get">
					<select id="searchCondition" name="searchCondition">
						<option value="title">제목</option>
						<option value="writer">강의자</option>
					</select>
					<span class="input_area"> 
						<input type="search" name="searchValue">
					</span>
					<button type="submit">검색하기</button>
						<button type="button" onclick="location.href='#'">작성하기</button>
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