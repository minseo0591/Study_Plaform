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

<link href="css/styles.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>게시판 상세보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js%22%3E"></script>
<script>
	
	
</script>
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
						<colgroup>
							<col style="width : 20%;">
							<col style="width : 80%;">
						</colgroup>
						<c:forEach items="${dtlist }" var="aa">
						<tr>
							<th scope="col" class="text-center">제목</th>
							<td>${aa.comu_title }</td>
						</tr>
						<tr>
							<th scope="col" class="text-center">작성자</th>
							<td>${aa.stu_id }</td>
						</tr>
						<tr>
							<th scope="col" class="text-center">날짜</th>
							<td>${aa.comu_date }</td>
						</tr>
						<tr>
							<th scope="col" class="align-middle text-center">내용</th>
							<td>
								<textarea rows="20" cols="180" disabled>${aa.comu_contents }</textarea>
							</td>
						</tr>
						</c:forEach>
					</table>
					<div class="d-flex justify-content-center">
					<a href="./communityListController.bo?page=1" class="btn btn-secondary">목록</a>
					&nbsp;
					<c:choose>
					<c:when test="${id eq ids }">
					<c:forEach items="${dtlist }" var="as">
					<a href="./comuUpdateController.bo?ids=${as.stu_id}&&number=${as.comu_num }" class="btn btn-primary">수정</a>
					&nbsp;
					<a href="./comunityDeleteController.bo?number=${as.comu_num }" class="btn btn-danger">삭제</a>
					</c:forEach>
					</c:when>
					</c:choose>
					
					
					</div>
				</form>
			</div>
		</div>
	</div>
	</main>

	<!-- Comments section-->
	<section class="mb-5">
		<div class="card bg-light">
			<div class="card-body">
				<!-- Comment form-->
				<c:forEach items="${dtlist }" var="ax">
				<form class="mb-4" action="./comuReplyAddController.bo?number=${number }&reply_contents=${reply_contents}">
				
			 <input type="hidden" name="number" value="${comuNum }" readOnly>
			 <h3 style="widht:100%">댓글 작성자 : ${id } </h3>
			 	
					<textarea class="form-control" rows="3"
						placeholder="댓글을 입력해주세요." name="reply_contents"></textarea>
						<button type="submit" class="btn btn-primary float-end" style="margin-top:10px;">댓글등록</button>
				</form>
				</c:forEach>
				
				
				<c:forEach items="${replyList }" var="rp" varStatus="vs">
				<!-- Comment with nested comments-->
				<div class="d-flex mb-4">
					<!-- Parent comment-->
					<div class="flex-shrink-0">
						<img class="rounded-circle"
							src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." />
					</div>
					<div class="ms-3">
						<div class="fw-bold">${rp.stu_id }</div>
						${rp.reply_contents }
						<br>
						${rp.reply_date }
						<div>
						<c:if test="${id eq rp.stu_id }">
	                	<a href="#" class="float-right btn-box-tool replyModBtn" data-bs-toggle="modal" data-bs-target="#exampleModal${vs.index }" data-bs-whatever="@mdo">
	                    <i class="fa fa-edit"> 수정</i>
	                	</a>
	                	<a href="./comuReplyDeleteController.bo?number=${rp.comu_num }&level=${rp.reply_level}" class="float-right btn-box-tool replyDelBtn" data-toggle="modal" data-target="#delModal">
	                    <i class="fa fa-times">삭제</i>
	                	</a></c:if>
	                	</div>
					</div>
				</div>
					<div class="modal fade" id="exampleModal${vs.index }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  					<div class="modal-dialog">
  
    				<div class="modal-content">
      					<div class="modal-header">
       						 <h5 class="modal-title" id="exampleModalLabel">댓글 수정하기</h5>
       						 <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      					</div>
      					<form action="./comuReplyUpdateController.bo">
      				<div class="modal-body">
         				 <div class="mb-3">
          				  <label for="message-text" class="col-form-label">내용</label>
            				<textarea class="form-control" id="message-text" rows="10" name="reUpcontents">${rp.reply_contents }</textarea>
          				</div>
      				</div>
      				<input type="hidden" name="level" value="${rp.reply_level }">
      				<input type="hidden" name="number" value="${comuNum }">
      				<div class="modal-footer">
      				  <button type="submit" class="btn btn-primary">수정하기</button>
        				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
     				 </div>
     				 </form>
    				</div>
    
  						</div>
					</div>
				</c:forEach>
				
				
			</div>
		</div>
	</section>
	
	
	<jsp:include page="/HF_Page/footer.jsp"/>
	<script src="js/scripts.js"></script>
</body>
</html>
