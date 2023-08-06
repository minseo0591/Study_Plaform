<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
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
<title>게시판 수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="sb-nav-fixed">
<jsp:include page="/HF_Page/header.jsp"/>
	<main>
	<div class="container-fluid px-4">
		<h1 class="mt-4">게시판 수정하기</h1>
		<div class="card mb-4">
			<div class="card-body">
				<form>
				<c:forEach items="${ dtlist}" var="aa">
					<table class="table table-bordered">
						<colgroup>
							<col style="width : 20%;">
							<col style="width : 80%;">
						</colgroup>
						<tr>
							<th class="text-center">글 번호 </th>
							<td><input type="text" value="${aa.comu_num }" name="number" readOnly></td>
						</tr>
						<tr>
							<th class="text-center">제목 </th>
							<td><input type="text" value="${aa.comu_title }" name="title"></td>
						</tr>
						<tr>
							<th class="text-center">작성자</th>
							<td><input type="text" name="ids" value="${aa.stu_id }" readOnly></td>
						</tr>
						<tr>
							<th class="text-center">날짜</th>
							<td>${aa.comu_date }</td>
						</tr>
						<tr>
							<th scope="col" class="align-middle text-center">내용</th>
							<td>
								<textarea rows="20" cols="130" name="content">${aa.comu_contents }</textarea>
							</td>
						</tr>
					</table>
					
					<div class="d-flex justify-content-center">
					<a href="list" class="btn btn-secondary">목록</a>
					&nbsp;
					<button type="submit" onclick="location.href='./comuUpdateController.bo?ids=${aa.stu_id}&number=${aa.comu_num }&title=${title}&content=${content}';" class="btn btn-primary">수정하기</button>
					&nbsp;
					<c:forEach items="${dtlist }" var="aa">
					<a href="#" class="btn btn-primary" onclick="location.href='./comuDetailController.bo?ids=${aa.stu_id}&&number=${aa.comu_num }';">돌아가기</a>
					</c:forEach>
					</div>
					</c:forEach>
				</form>
			</div>
		</div>
	</div>
	</main>
	<jsp:include page="/HF_Page/footer.jsp"/>
</body>
</html>