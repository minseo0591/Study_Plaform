<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!DOCTYPE html>
<html lang="ko">
<head>
<title>게시판 수정</title>
</head>
<body class="sb-nav-fixed">
<jsp:include page="/HF_Page/header.jsp"/>
	<main>
	<div class="container-fluid px-4">
		<h1 class="mt-4">게시판 수정하기</h1>
		<div class="card mb-4">
			<div class="card-body">
				<form action="./noticeUpdateController.nc?no_id=${noticeUp.no_id}" method="post">
					<table class="table table-bordered">
					<%-- 	<colgroup>
							<col style="width : 20%;">
							<col style="width : 80%;">
						</colgroup> --%>
						<tr>
							<th class="text-center">제목</th>
							<td><input type="text" name="upd_title" value="${noticeUp.no_title}"></td>
						</tr>
						<tr>
							<th class="text-center">작성자</th>
							<td><input type="text" name="admin_id" value="${noticeUp.admin_id}" readonly/></td>
						</tr>
						<tr>
							<th class="text-center">날짜</th>
							<td><input type="text" name="upd_date" value="${noticeUp.no_date}"readonly/></td>
							</tr>
						<tr>
							<th scope="col" class="align-middle text-center">내용</th>
							<td>
								<textarea rows="20" cols="150" name="upd_content">${noticeUp.no_content}</textarea>
							</td>
						</tr>
					</table>
					<div class="d-flex justify-content-center">
					<a href="./noticeListController.nc?page=1" class="btn btn-secondary">목록</a>
					&nbsp;
					<button type="submit" class="btn btn-primary">수정하기</button>
					&nbsp;
					<a  class="btn btn-primary" onclick="history.back()">돌아가기</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	</main>
	<jsp:include page="/HF_Page/footer.jsp"/>
</body>
</html>
