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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>강의 소개</title>
    <link rel="icon" href="KJH_logo_icon.png" />
    <script
      src="https://kit.fontawesome.com/0bca6ce86d.js"
      crossorigin="anonymous">
    </script>
 
    <link rel="stylesheet" href="/Study_Platform/LecturePages/css/test003.css" />
</head>
<body>
  <!-- header -->
  <jsp:include page="/HF_Page/header.jsp"/>
  <!-- header end -->

      <div class="position-relative overflow-hidden bg-light d-flex justify-content-center" style="padding:10px;">
        <!-- <div class="col-md-12 p-lg-3 mx-auto"> -->
        <c:set var="img" value="/img/"/>
        		<c:choose>
                <c:when test="${lecture.lec_thum ne img}">
                <div>
          		<img src="${lecture.lec_thum}" class="img-fluid" style="width: 400px; height: 250px; margin-bottom: 30px; margin-right : 15px;">
          		</div>
                </c:when>
                <c:when test="${lecture.lec_thum eq img}">
                <div>
                  <img src="/Study_Platform/img/imgnull.jpg" class="img-fluid" style="width: 400px; height: 300px; margin-bottom: 30px; margin-right : 15px;">
                </div>
                </c:when>
         </c:choose>
          <div style="float:left;"><h3>${lecture.lec_title}</h3>
          <p class="lead fw-normal">
          <c:choose>
	      	<c:when test="${avg == 1}">
	         &#x2B50(1.0)
	        </c:when>
	        <c:when test="${avg == 2}">
	         &#x2B50&#x2B50(2.0)
	        </c:when>
	        <c:when test="${avg == 3}">
	        &#x2B50&#x2B50&#x2B50(3.0)
	        </c:when>
	        <c:when test="${avg == 4}">
	        &#x2B50&#x2B50&#x2B50&#x2B50(4.0)
	        </c:when>
	        <c:when test="${avg == 5}">
	        &#x2B50&#x2B50&#x2B50&#x2B50&#x2B50(5.0)
	        </c:when>
	        </c:choose>
          <br>
            ${StarCount}개의 수강평</p>
            <p>강의자 : <b>${lecture.lec_lecturer}</b></p>
          <a class="btn btn-primary" href="./Vmap.lc?lec_id=${lecture.lec_id}&&level=1&&lec_title=${lecture.lec_title}">수강 신청하기</a>
          </div>
        <!-- </div> -->
        <div class="product-device shadow-sm d-none d-md-block"></div>
        <div class="product-device product-device-2 shadow-sm d-none d-md-block"></div>
      </div>
    <div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-7">
              <br>
                  <h5><b>[${lecture.lec_title}] 강의입니다.</b></h5>
                  <div>
                  </div>
                <!-- <div class="d-flex flex-row border border-secondary rounded-3" style="height:100px;">
                  <div style="margin-right: 80px; margin-top: 10px;">
                  <div style="margin-left: 80px;">
                  &nbsp;&nbsp;✍️<br>
                  <b>이런 걸<br></b>
                  <b>배워요!</b>
                  </div>
                  </div>
                  <div style="margin-top: 12px;">
                    <div><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check" viewBox="0 0 16 16">
                      <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"/>
                    </svg>Kotlin과 Java를 함께 사용할 때 주의할 점</div>
                  </div>
                </div> -->
                <div class="rounded-3" style="height: 80px; background-color:rgb(71, 133, 240);">
                  <div class="text-center fw-bolder" style="color: white; padding-top: 10px;">${lecture.lec_category}을 공부하고 싶다면?<br>
                    ⭐ ${lecture.lec_title} ⭐
                  </div>
                </div>
                <!-- <div>
                  <img src="img/이미지1.jpg" class="img-thumbnail">
                </div> -->
                <br>
                <div>
                 ${lecture.lec_contenta}
                </div>
                <hr>
                 <c:choose>
                <c:when test="${lecture.lec_sectiona ne img}">
                <div>
                  <img src="${lecture.lec_sectiona}" class="img-thumbnail">
                </div>
                </c:when>
                <c:when test="${lecture.lec_sectiona eq img}">
                <div>
                  <img src="/Study_Platform/img/imgnull.jpg" class="img-thumbnail">
                </div>
                </c:when>
                 </c:choose>
               <br>
                <hr>
                <c:choose>
                <c:when test="${lecture.lec_sectionb ne img}">
                <div>
                  <img src="${lecture.lec_sectionb}" class="img-thumbnail">
                </div>
                </c:when>
                <c:when test="${lecture.lec_sectionb eq img}">
                <div>
                  <img src="/Study_Platform/img/imgnull.jpg" class="img-thumbnail">
                </div>
                </c:when>
                 </c:choose>
                <hr>
                <br>
                <div>
                  ${lecture.lec_contentb}
                </div>
                <hr>
                <div>
                  <h4><b>커리큘럼</b></h2><p class="fw-light">총 ${lecture.lec_level} 개</p>
                </div>
                
                <div>
                  <div class="accordion" id="accordionExample">
                    <div class="accordion-item">
                      <h2 class="accordion-header" id="headingOne">
                        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        강의 리스트
                        </button>
                      </h2>
                      <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">

                       <c:forEach items="${test}" var="aa">
                        <div class="accordion-body">
                          <a>
                          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-play-circle" viewBox="0 0 16 16">
                            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                            <path d="M6.271 5.055a.5.5 0 0 1 .52.038l3.5 2.5a.5.5 0 0 1 0 .814l-3.5 2.5A.5.5 0 0 1 6 10.5v-5a.5.5 0 0 1 .271-.445z"/>
                          </svg>
                        </a>
                          <strong>
                          ${aa}
                          <span class="float-end"></span></strong>
                        </div>
                        </c:forEach>

                      </div>
                    </div>
                  </div>
                </div>
                
                <hr>
                <div>
                  <h4><b>수강평</b></h2>
                </div>

                <div class="card mb-3" style="max-width: 540px;">
                  <div class="row g-0">
                    <div class="col-md-4">
                      <div style="margin-top: 60px;">
                        <div class="fs-1 fw-bolder" style="text-align: center;">${avg}.0
                          <div class="fs-5">
                           <c:choose>
	                      <c:when test="${avg == 1}">
	                      &#x2B50
	                      </c:when>
	                      <c:when test="${avg == 2}">
	                      &#x2B50&#x2B50
	                      </c:when>
	                      <c:when test="${avg == 3}">
	                      &#x2B50&#x2B50&#x2B50
	                      </c:when>
	                      <c:when test="${avg == 4}">
	                      &#x2B50&#x2B50&#x2B50&#x2B50
	                      </c:when>
	                      <c:when test="${avg == 5}">
	                      &#x2B50&#x2B50&#x2B50&#x2B50&#x2B50
	                      </c:when>
	                      </c:choose>
                          </div>
                          <div class="fs-6">${StarCount}개의 수강평</div>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-8">
                      <div class="card-body" style="margin-top: 5px;">
                        <div class="card-text">5점
                          <div class="progress">
                            <div class="progress-bar" style="width: ${percentfive}%;">
                            </div>
                          </div>
                      </div>
                        <div class="card-text">4점
                          <div class="progress">
                            <div class="progress-bar" style="width: ${percentfour}%;">
                            </div>
                          </div>
                        </div>
                        
                        <div class="card-text">3점
                          <div class="progress">
                            <div class="progress-bar" style="width: ${percentthree}%;">
                            </div>
                          </div>
                        </div>
                        <div class="card-text">2점
                          <div class="progress">
                            <div class="progress-bar" style="width: ${percenttwo}%;">
                            </div>
                          </div>
                        </div>
                        <div class="card-text">1점
                          <div class="progress">
                            <div class="progress-bar" style="width: ${percentone}%;">
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="card mb-2">
                  <div class="card-header bg-light">
                          <i class="fa fa-comment fa"></i>&nbsp;수강평 남기기
                  </div>
                  <div class="card-body">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                      <div class="form-inline mb-2">
                       
                      </div>
                      <form name="myform" id="myform" method="post" action="./lectureCommentAddController.lc?lec_id=${lecture.lec_id}&&id=${id}">
                        <fieldset>
                            <legend>별점을 선택해주세요</legend>
                            <input type="radio" name="rating" value="5" id="rate1"><label for="rate1">⭐</label>
                            <input type="radio" name="rating" value="4" id="rate2"><label for="rate2">⭐</label>
                            <input type="radio" name="rating" value="3" id="rate3"><label for="rate3">⭐</label>
                            <input type="radio" name="rating" value="2" id="rate4"><label for="rate4">⭐</label>
                            <input type="radio" name="rating" value="1" id="rate5"><label for="rate5">⭐</label>
                        </fieldset>
                      <textarea class="form-control" id="exampleFormControlTextarea1" name="tess" rows="3"></textarea>
                      <button type="submit" class="btn btn-dark mt-3">등록</button>
                      
                        </li>
                    </ul>
                    </form>
                  </div>
                </div>
                
                <hr>
				<c:forEach items="${s1}" var="x">
	                <div class="card mb-2">
	                <div class="card-header bg-light">
	                        <i class="fa fa-comment fa"></i> 수강평 댓글
	                </div>
	                <div class="card-body">
	                  <ul class="list-group list-group-flush">
	                      <li class="list-group-item">
	                    <div class="form-inline mb-2">
	                      <label for="replyId" class="fw-bolder"><i class="fa fa-user-circle-o fa-2x"></i><span style="color:gray;">&nbsp; ${x.stu_id }</span><div class="fs-6">
	                      <c:choose>
	                      <c:when test="${x.co_rating == 1}">
	                      &#x2B50
	                      </c:when>
	                      <c:when test="${x.co_rating == 2}">
	                      &#x2B50&#x2B50
	                      </c:when>
	                      <c:when test="${x.co_rating == 3}">
	                      &#x2B50&#x2B50&#x2B50
	                      </c:when>
	                      <c:when test="${x.co_rating == 4}">
	                      &#x2B50&#x2B50&#x2B50&#x2B50
	                      </c:when>
	                      <c:when test="${x.co_rating == 5}">
	                      &#x2B50&#x2B50&#x2B50&#x2B50&#x2B50
	                      </c:when>
	                      </c:choose>
	                      </div></label>
	                    </div>
	                    <div class="fw-bolder">
	                      ${x.co_comment}
	                    </div>
	                    <div class="fw-bolder" style="color:gray; padding-top: 10px;">
	                      ${x.co_date } - 작성
	                    </div>
	                      </li>
	                  </ul>
	                </div>
	              </div>
              </c:forEach>

            </div>
            <div class="col"> 
                <div class="rounded-3" style="width: 300px; padding: 10px 10px; position: -webkit-sticky; position: sticky; top: 50px; text-align: center; margin-top: 50px; border: 1px solid rgb(194, 193, 193); box-shadow:2px 3px 5px 0px;">
                  <div>
                    <b>${lecture.lec_title}</b>
                  </div>
                  <button type="button" style="width: 200px; margin-top: 10px;" class="btn btn-primary" onclick="location.href='./Vmap.vc?lec_id=${lecture.lec_id}&&level=1&&lec_title=${lecture.lec_title }';">수강신청 하기</button>
                <!--   <div style="margin-top: 10px;">
                    <button type="button" style="width: 200px;" class="btn btn-outline-secondary">북마크 추가</button>
                  </div> -->
                  <hr>
                  <div>
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">강의자 : <b>${lecture.lec_lecturer}</b></li>
                    <li class="list-group-item">총 강의수 : <b>${lecture.lec_level}개</b></li>
                    <li class="list-group-item">카테고리 : <b>${lecture.lec_category}</b></li>
                  </ul>
                  </div>
                </div>
            </div>
        </div>
        <!--첫번째 줄-->
         <!-- FOOTER -->
          <jsp:include page="/HF_Page/footer.jsp"/>
        <!--컨테이너-->
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="test.js"></script>
</body>
</html>