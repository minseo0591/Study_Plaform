<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        
        <!-- 네이버 스마트 에디터 js 파일 -->
        <script type="text/javascript" src="/Study_Platform/smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>
        
		 <!-- jquery UI CSS파일 -->
         <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css"/>
         <!-- jquery 기본 js 파일 -->
         <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
         <!-- jquery UI 라이브러리 js파일 -->
         <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<!-- <script>
    function fn_addFile(){
        $("#d_file").append("<input class='form-control form-control-sm' id='formFileSm' type='file' name='file'>");
    }
</script> -->
<script type="text/javascript" src="/Study_Platform/Admin_page/preview/light/js/img.js"></script>
<link rel="stylesheet" href="/Study_Platform/Admin_page/preview/light/css/img.css">

<title>강의 등록 페이지</title>
</head>
<body>
<div class="container">
  <main>
  <form action="./lectureJoinController.lc" method="post" enctype="multipart/form-data" id="frm">
    <div class="py-5 text-center">
      <h2>강의 등록</h2>
    </div>

    <div class="row g-5">
      <div class="col-md-5 col-lg-4 order-md-last">
        <h4 class="d-flex justify-content-between align-items-center mb-3">
          <span class="text-primary">동영상 이미지 삽입</span>
        </h4>
        <span class="badge bg-primary text-wrap">이미지를 클릭하면 팝업으로 이미지를 보여줍니다.</span>
        <div class="card p-2">
        	<!-- <img src="/Study_Platform/Admin_page/img/200x200.png" id="img" class="img-thumbnail" alt="#" onclick="change(this)" style="cursor: pointer;"> -->
        	<img id="previewImg" onclick="popImage(this.src)" src="/Study_Platform/Admin_page/img/200x200.png">

        	<hr> 
        	<!-- <input class="form-control form-control-sm upload-hidden" id="formFileSm" type="file" name="file">
        	<input class="form-control form-control-sm upload-hidden" id="formFileSm" type="file" name="file2">
        	<input class="form-control form-control-sm upload-hidden" id="formFileSm" type="file" name="file3"> -->
        	<label class="text-center"><b>썸네일 이미지</b></label>
        	<div class="uploadImg">
		        <div class="filebox">
		            <input class="upload-name" value="선택된 파일 없음" disabled="disabled">
		            <input type="file" id="file" class="upload-hidden form-control form-control-sm" name="file">
		            <label for="file">이미지 첨부</label> 
		        </div>
		    </div>
		    <hr>
		    
		    <div class="uploadImg2">
		        <div class="filebox">
		            <input class="upload-name" value="선택된 파일 없음" disabled="disabled">
		            <input type="file" id="file2" class="upload-hidden form-control form-control-sm" name="file2">
		            <label for="file2">이미지 첨부</label> 
		        </div>
		    </div>
		    
		    <div class="uploadImg3">
		        <div class="filebox">
		            <input class="upload-name" value="선택된 파일 없음" disabled="disabled">
		            <input type="file" id="file3" class="upload-hidden form-control form-control-sm" name="file3">
		            <label for="file3">이미지 첨부</label> 
		        </div>
		    </div>
   			<!-- <input type="button" class="btn btn-primary" value="파일 추가" onClick="fn_addFile()">
   			 <div id="d_file">
            	<input class="form-control form-control-sm" id="formFileSm" type="file" name="file">
            </div> -->
        </div>
      </div>
      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">강의 등록하기</h4>
        <hr>
        <div class="needs-validation">
          <div class="row g-3">
            <div class="col-sm-6">
              <label for="firstName" class="form-label">강좌 제목 <span style="color:FF6600">⭐</span></label>
              <input type="text" class="form-control" id="firstName" name="lec_title" placeholder="" value="" required>
            </div>

            <div class="col-sm-6">
              <label for="lastName" class="form-label">강의자 <span style="color:FF6600">⭐</span></label>
              <input type="text" class="form-control" id="lastName" name="lec_lecturer" placeholder="" value="" required>
            </div>

            <div class="col-12">
              <label for="username" class="form-label">강의소개</label>
              <div class="input-group has-validation">
                <textarea class="form-control" id="message-text" name="lec_contenta"></textarea>
              </div>
            </div>
            
            <!-- SmartEditor2  -->
            <div class="col-12">
              <label for="username" class="form-label">자기소개</label>
              <div class="input-group has-validation">
                <textarea class="form-control" id="smartEditor" name="lec_contentb" style="width: 100%;"></textarea>
              </div>
            </div>
            
            
			<label for="email" class="form-label">영상등록 <span style="color:FF6600">⭐</span></label>
					<div class="accordion" id="first">
						<div class="accordion-item" id="second">
							<h2 class="accordion-header" id="headingOne">
								<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
		           					강의 &nbsp;&nbsp; &nbsp;	<input type="text"style="width:200px" class="form-control form-control-sm" id="recipient-name"name="cm_title" placeholder="강의 제목을 입력해주세요!">
		           				</button>
		                    </h2>
		                <div id="collapseOne" class="accordion-collapse collapsed" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
		                  <div class="accordion-body">
		                  
		            <div class="col-12">
		              		<table class="table" id="myTable">
		                    <thead>
		                      <tr>
		                        <th scope="col" style="font-size: 13px;">#</th>
		                        <th scope="col" style="font-size: 13px;">유튜브 링크<br/>(동영상ID) <span style="color:FF6600">⭐</span></th>
		                        <th scope="col" style="font-size: 13px;">영상이름 <span style="color:FF6600">⭐</span></th>
		                        <th></th>
		                      </tr>
		                    </thead>
		                    <tbody id="tbody"> 
		                      <tr>
		                        <th scope="row">1</th>
		                        <td><input type="text" class="form-control form-control-sm"  name="lec_url" placeholder="URL 또는 영상ID" required></td>
		                        <td><input type="text" class="form-control form-control-sm"  name="cm_chtitle" required></td>
		                   	    <td><a class="btn btn-link" style="margin-top: -5px;" onclick="rowDelete();"></a></td>
		                      </tr>
		                    </tbody>
		                  </table>
		                <a style="margin-left: 400px;" class="btn btn-link" onclick="rowAdd();"> 
		                   <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
		                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
		                        <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
		                   </svg>
		                </a>
		            </div>
		            	</div>
		            	</div>
		            		</div>
			
            	
            		

            <div class="col-md-5">
              <label for="country" class="form-label">강좌 카테고리</label>
              <select class="form-select" id="CategoryUp" name="CategoryUp" required>
                <option value="0" selected="selected">카테고리를 선택하세요</option>
                <option value="1">개발 &#8226; 프로그래밍</option>
                <option value="2">교과목</option>
                <option value="3">외국어</option>
              </select>
            </div>

            <div class="col-md-4">
              <label for="state" class="form-label">강좌 카테고리</label>
              <select class="form-select" id="CategoryDown" name="CategoryDown" required>
                <option value="0">세부사항을 선택하세요</option>
                <option value="프로그래밍" class="mall1">프로그래밍</option>
                <option value="HTML" class="mall1">HTML</option>
                <option value="CSS" class="mall1">CSS</option>
                <option value="자바스크립트" class="mall1">자바스크립트</option>
                
                <option value="국어" class="mall2">국어</option>
                <option value="영어" class="mall2">영어</option>
                <option value="수학" class="mall2">수학</option>
                <option value="사회" class="mall2">사회</option>
                
                <option value="일본어" class="mall3">일본어</option>
                <option value="중국어" class="mall3">중국어</option>
                <option value="영어회화" class="mall3">영어회화</option>
                <option value="스페인어" class="mall3">스페인어</option>
              </select>
            </div>

          </div>

          <hr class="my-4">

          <div class="row gy-3">
          </div>

          <button type="submit" class="w-100 btn btn-primary btn-lg" value="등록하기" id="save" />등록하기
        </form>
      </div>
    </div>
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2022 KJH Admin</p>
  </footer>
</div>

<script type="text/javascript">
var malls = false;

function update_selected() {
  $("#CategoryDown").val(0);
  $("#CategoryDown").find("option[value!=0]").detach();

  $("#CategoryDown").append(malls.filter(".mall" + $(this).val()));
}

$(function() {
  malls = $("#CategoryDown").find("option[value!=0]");
  malls.detach();

  $("#CategoryUp").change(update_selected);
  $("#CategoryUp").trigger("change");
});
</script>
	
<script type="text/javascript">
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors,
		elPlaceHolder : "smartEditor", //저는 textarea의 id와 똑같이 적어줬습니다.
		sSkinURI : "/Study_Platform/smarteditor2/SmartEditor2Skin.html", //경로를 꼭 맞춰주세요!
		fCreator : "createSEditor2",
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
	
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
	
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true,
			fOnBeforeUnload : function(){
                  
            },
            fOnAppLoad : function(){
                //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
                oEditors.getById["smartEditor"].exec("PASTE_HTML", ["기존 DB에 저장된 내용을 에디터에 적용할 문구"]);
            },
            fCreator: "createSEditor2"
		}
	})
	
	$(function() {
		$("#save").click(function() {
			oEditors.getById["smartEditor"].exec("UPDATE_CONTENTS_FIELD", []); 
			//textarea의 id를 적어줍니다.
			/* $("#frm").submit(); */
		});
	});
</script>

<script>
		function rowAdd() {
		    var trCnt = $('#myTable tr').length;
		    if(trCnt) {
		        var innerHtml = "";
		        innerHtml += '<tr>';
		        innerHtml += '      <th scope="row">'+trCnt+'</th>';
		        innerHtml += '      <td><input type="text" class="form-control form-control-sm" id="recipient-name" name="lec_url"  placeholder="url 또는 영상id를 입력하세요."></td>';
		        innerHtml += '      <td><input type="text" class="form-control form-control-sm" id="recipient-name" name="cm_chtitle"></td>';
		
		        innerHtml += '      <td><button class="btn btn-link" style="margin-top: -5px;" onclick="rowDelete();"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-dash-circle" viewBox="0 0 16 16"><path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/><path d="M4 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 4 8z"/></svg></button></td>';
		        innerHtml += '</tr>';
		
		        $('#myTable > tbody:last').append(innerHtml);
		    } else {
		        alert(" ");
		        return false;
		    }
		}
</script>

<script>

    function rowDelete() {
        var trCnt = $('#myTable tr').length;
        if(trCnt > 2) {
            $('#myTable > tbody:last > tr:last').remove();
        }else {
            return false;
        }
    }
    
</script>

<script type="text/javascript" src="/Study_Platform/smarteditor2/sample/photo_uploader/attach_photo.js" charset="utf-8"></script>
</body>
</html>