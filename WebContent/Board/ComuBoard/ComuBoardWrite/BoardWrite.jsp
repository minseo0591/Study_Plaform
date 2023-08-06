<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<title>커뮤니티 글쓰기</title>

    
</head>

<body>
	<jsp:include page="/HF_Page/header.jsp"/>
	<article>
		<div class="container" role="main">
			<h2 style="padding:10px;">커뮤니티 게시판 글쓰기</h2>
			<form name="form" id="form" role="form" method="post" action="./comuAddController.bo">
				<div class="mb-3">
					<label for="title">제목</label> <input type="text"
						class="form-control" name="title" id="title"
						placeholder="제목을 입력해 주세요">
				</div>
				
				<!-- <div class="mb-3">
					<label for="reg_id">작성자</label> <input type="text"
						class="form-control" name="reg_id" id="reg_id"
						placeholder="이름을 입력해 주세요">
				</div> -->

				<div class="mb-3">
					<label for="content">내용</label>
					<textarea class="form-control" rows="23" name="content" id="content"
						placeholder="내용을 입력해 주세요"></textarea>
				</div>

				<!-- <div class="mb-3">
					<label for="tag">TAG</label> <input type="text" class="form-control" name="tag" id="tag" placeholder="태그를 입력해 주세요">
				</div> -->
			

				<div style="padding:10px;">
				<button type="submit" class="btn btn-primary" id="btnSave">저장</button>
				<button type="button" class="btn btn-primary" id="btnList" onclick="location.href='./communityListController.bo?page=1';">목록</button>
				</div>
				</form>
		</div>
	
	</article>
	<jsp:include page="/HF_Page/footer.jsp"/>
</body>
</html>