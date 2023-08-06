<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>커뮤니티 게시판</title>
<link rel="stylesheet" href="/Study_Platform/Board/ComuBoard/ComuBoardList/boardlist.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="/HF_Page/header.jsp"/>
	<div class="outer">
		<div class="wrap">
			<div class="board_area">
				<div class="board_title">
					<h1>커뮤니티 게시판</h1>
				</div>
				<div class="board_list">
					<ul class="board_header">
						<li class="id">글번호</li>
						<li class="category" style="width: 200px;">분류</li>
						<li class="title" style="width: 400px;">제목</li>
						<li class="writer">작성자</li>
						<!-- <li class="count">조회수</li> -->
						<li class="date">작성일</li>
					</ul>
				
				 <c:forEach var="list" items="${comulist }" varStatus="vs">
				<ul class="board_ul" onclick="location.href='./comuDetailController.bo?number=${list.comu_num }';">
					<li class="id">${list.comu_num }</li>
					<li class="category" style="width: 200px;">커뮤니티</li>
					<li class="title" style="width: 400px;">${list.comu_title }
					</li>
					<li class="writer">${list.stu_id }</li>
					<!-- <li class="count">10</li> -->
					<li class="date">${list.comu_date }</li>
				</ul>
				</c:forEach>
			</div>
			

			<ul class="board_paging">
			
				
				<!-- 이전 페이지로 -->
				 <c:choose>
			<c:when test="${startpage <= 1}">
            </c:when>
            <c:otherwise>
            <li>
				<a href="./communityListController.bo?page=${startpage-10}">&lt;</a>
			</li>
            </c:otherwise>
            </c:choose>
			
			
	         <c:if test="${startpage <= endpage}">
				<c:forEach var="i" begin="${startpage}" end="${endpage}">
				<c:choose>
				<c:when test="${searchWord eq null && keyWord eq null}">
	            <li>
						<a href="./communityListController.bo?page=${i}" class=current_page>${i }</a>
					</li>
	            </c:when>
	            <c:otherwise>
					<li>
						<a href="./comuSearchController.bo?page=${i}&keyWord=${keyWord}&searchWord=${searchWord}">${i}</a>
					</li>
					</c:otherwise>
					</c:choose>
					</c:forEach>
			</c:if>
			
				<!-- 다음페이지로 -->
				
			<c:choose>
            <c:when test="${startpage+9 >= maxpage}">
            </c:when>
            <c:otherwise>
            <li>
						<a href="./communityListController.bo?page=${startpage+10}">&gt;</a>
			</li>
            </c:otherwise>
            </c:choose>
			</ul>
			 
            
			<div class="search_area">
				<form method="get" action="./comuSearchController.bo?page=${page}&keyWord=${keyWord}&searchWord=${searchWord}">
					<select id="searchCondition" name="keyWord">
						<option value="comu_title">제목</option>
						<!-- <option value="content">내용</option> -->
						<option value="stu_id">작성자</option>
					</select>
					<span class="input_area"> 
						<input type="search" name="searchWord">
					</span>
					<button type="submit">검색하기</button>
						<button type="button" onclick="location.href='./comuBoardWrite.bo';">작성하기</button>
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