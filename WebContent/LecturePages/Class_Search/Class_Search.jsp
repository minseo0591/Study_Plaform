<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>최근 시청한 강의목록</title>

    

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>


    <style>

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
  </head>
  <body class="bg-light">

    <jsp:include page="/HF_Page/header.jsp"/>
<main class="container">

  <div class="my-3 p-3 bg-body rounded shadow-sm">
    <h4 class="border-bottom pb-2 mb-0 fw-bolder">학습중인 강의 목록</h4>
    <div class="d-flex text-muted pt-3">
    
        <table class="table text-center">
            <thead>
              <tr>
                <th scope="col">수강 번호</th>
                <th scope="col">강의 제목</th>
                <th scope="col">강사자 이름</th>
                <th scope="col">최근 시청날짜</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>이건 테스트</td>
                <td>공선환</td>
                <td>2022-10-01</td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>이건 테스트</td>
                <td>정성진</td>
                <td>2022-10-01</td>
              </tr>
              <tr>
                <th scope="row">3</th>
                <td>이건 테스트</td>
                <td>한민서</td>
                <td>2022-10-01</td>
              </tr>
              <tr>
                <th scope="row">4</th>
                <td>이건 테스트</td>
                <td>테스트22</td>
                <td>2022-10-01</td>
              </tr>
              <tr>
                <th scope="row">4</th>
                <td>이건 테스트</td>
                <td>관리자2</td>
                <td>2022-10-01</td>
              </tr>
              <tr>
                <th scope="row">5</th>
                <td>이건 테스트</td>
                <td>관리자33</td>
                <td>2022-10-01</td>
              </tr>
              <tr>
                <th scope="row">6</th>
                <td>이건 테스트</td>
                <td>관리자44</td>
                <td>2022-10-01</td>
              </tr>
              <tr>
                <th scope="row">7</th>
                <td>이건 테스트</td>
                <td>테스트22</td>
                <td>2022-10-01</td>
              </tr>
              <tr>
                <th scope="row">8</th>
                <td>이건 테스트</td>
                <td>테스트22</td>
                <td>2022-10-01</td>
              </tr>
              <tr>
                <th scope="row">9</th>
                <td>이건 테스트</td>
                <td>테스트22</td>
                <td>2022-10-01</td>
              </tr>
              <tr>
                <th scope="row">10</th>
                <td>이건 테스트</td>
                <td>테스트22</td>
                <td>2022-10-01</td>
              </tr>
            </tbody>
          </table>
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
          <li class="page-item">
            <a class="page-link" href="#" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
          <li class="page-item active"><a class="page-link" href="#">1</a></li>
          <li class="page-item"><a class="page-link" href="#">2</a></li>
          <li class="page-item"><a class="page-link" href="#">3</a></li>
          <li class="page-item">
            <a class="page-link" href="#" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
        </ul>
      </nav>
    <small class="d-block text-end mt-3">
      <button class="btn btn-primary" href="#">돌아가기</button>
    </small>
  </div>
</main>
<jsp:include page="/HF_Page/footer.jsp"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="./js/test.js"></script>
  </body>
</html>
    