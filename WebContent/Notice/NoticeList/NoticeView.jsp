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
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!DOCTYPE html>
<html lang="ko">
<head>
<title>게시판 상세보기</title>
</head>
<body class="sb-nav-fixed">
<jsp:include page="/HF_Page/header.jsp"/>
	<main>
	<div class="container-fluid px-4">
		<h1 class="mt-4">게시판 상세보기</h1>
		<div class="card mb-4">
			<div class="card-body">
				<form>
					<table class="table table-bordered">
					<%-- 	<colgroup>
							<col style="width : 20%;">
							<col style="width : 60%;">
						</colgroup> --%>
						<tr>
							<th class="text-center">제목</th>
							<td>${noticeDe.no_title}</td>
								
						</tr>
						
						<tr>
							<th class="text-center" >작성자</th>
							<td>${noticeDe.admin_id}</td>
						</tr>
						<tr>
							<th class="text-center">날짜</th>
							<td>${noticeDe.no_date}</td>
						</tr>
						<tr>
							<th scope="col" class="align-middle text-center">내용</th>
							<td>
								<textarea rows="20" cols="150" disabled>${noticeDe.no_content}</textarea>
							</td>
						</tr>
					</table>
					<div class="d-flex justify-content-center">
					<a href="./noticeListController.nc?page=1" class="btn btn-secondary">목록</a>
					&nbsp;
					<c:if test="${id eq noticeDe.admin_id}">
					<a href="./noticeUpdateViewController.nc?no_id=${noticeDe.no_id}" class="btn btn-primary">수정</a>
					&nbsp;
					<a href="./noticeDeleteController.nc?no_id=${noticeDe.no_id}"class="btn btn-danger" >삭제</a>
					</div>
					</c:if>
				</form>
			</div>
		</div>
	</div>
	</main>
	<jsp:include page="/HF_Page/footer.jsp"/>
</body>
</html>
