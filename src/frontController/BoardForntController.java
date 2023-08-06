package frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commuity_reply.comuReplyAddController;
import commuity_reply.comuReplyDeleteController;
import commuity_reply.comuReplyUpdateController;
import community.communityListController;
import community.comuAddController;
import community.comuDetailController;
import community.comuSearchController;
import community.comuUpdateController;
import community.comunityDeleteController;
import model.Action;
import model.ActionForward;

@WebServlet(name="BoardFrontController", urlPatterns ="*.bo")
public class BoardForntController extends HttpServlet {
	//3. doProcess()생성
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doProcess메서드 호출");
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	
	//4. 가상주소 가져오기 : 가지고 다닐 주소는 /*.lc 앞부분의 주소는 필요가 없다.
	String requestURI = request.getRequestURI();
	StringBuffer requestURL = request.getRequestURL();
	
	//uri와 url차이 -> uri에서 내 프로젝트명을 뺀 /lectureFrontController만 들고다니면됨
	System.out.println("리퀘스트uri: "+requestURI); ///Study_Platform/*.lc
	System.out.println("리퀘스트url: "+requestURL); //http://localhost:8000/*.lc
	
	//contextPath는 프로젝트명을 호출함
	String contextPath = request.getContextPath();
	System.out.println("contextPath: " + contextPath); ///Study_Platform
	
	//가상주소: 필요한 주소인 /*.lc 만 가져다니기 위해 substring()사용
	String command = requestURI.substring(contextPath.length());
	System.out.println("잘 짤렸는지 가상주소 command: " + command);
	
	//일회성이 아닌 다회용 여러번 쓸수있게 처리
	Action action = null;

	//6-3.ActionForward 객체사용
	ActionForward forward = null;
	
	 //커뮤니티 출력
	if(command.equals("/CommunityPage.bo")){
		System.out.println("가상주소: /CommunityPage.bo 주소 호출, 실제주소: ./Board/ComuBoard/ComuBoardList/ComuBoard_list.jsp");
		forward = new ActionForward();
		forward.setPath("./Board/ComuBoard/ComuBoardList/ComuBoard_list.jsp");
		forward.setRedirect(false);
	} //커뮤니티 리스트 컨트롤러
	else if(command.equals("/communityListController.bo")){ //주소에 .붙이면 안됨
        System.out.println("/communityListController.bo  주소 호출");
        action = new communityListController();
        try {
            System.out.println("communityListController 객체생성완료 후 excute()호출완료");
            forward = action.execute(request, response);
            System.out.println("커뮤니티 리스트 조회 :" + forward);
        } catch (Exception e) {
            e.printStackTrace();
        }
	} //커뮤니티 리스트 검색 기능
	else if(command.equals("/comuSearchController.bo")){ //주소에 .붙이면 안됨
        System.out.println("/comuSearchController.bo  주소 호출");
        action = new comuSearchController();
        try {
            System.out.println("comuSearchController 객체생성완료 후 excute()호출완료");
            forward = action.execute(request, response);
            System.out.println("커뮤니티 리스트 검색 조회 :" + forward);
        } catch (Exception e) {
            e.printStackTrace();
        }
	} //커뮤니티 글쓰기 출력
	else if(command.equals("/comuBoardWrite.bo")){
		System.out.println("가상주소: /comuBoardWrite.bo 주소 호출, 실제주소: ./Board/ComuBoard/ComuBoardWrite/BoardWrite.jsp");
		forward = new ActionForward();
		forward.setPath("./Board/ComuBoard/ComuBoardWrite/BoardWrite.jsp");
		forward.setRedirect(false);
	} //커뮤니티 글쓰기 컨트롤러
	else if(command.equals("/comuAddController.bo")){ //주소에 .붙이면 안됨
        System.out.println("/comuAddController.bo  주소 호출");
        action = new comuAddController();
        try {
            System.out.println("comuAddController 객체생성완료 후 excute()호출완료");
            forward = action.execute(request, response);
            System.out.println("커뮤니티 게시글 등록 컨트롤러 호출 :" + forward);
        } catch (Exception e) {
            e.printStackTrace();
        }
	} //커뮤니티 세부사항 출력
	else if(command.equals("/comuBoardDetail.bo")){
		System.out.println("가상주소: /comuBoardDetail.bo 주소 호출, 실제주소: ./Board/ComuBoard/ComuBoardDetail/BoardDetail.jsp");
		forward = new ActionForward();
		forward.setPath("./Board/ComuBoard/ComuBoardDetail/BoardDetail.jsp");
		forward.setRedirect(false);
	} //커뮤니티 세부사항 컨트롤러
	else if(command.equals("/comuDetailController.bo")){ //주소에 .붙이면 안됨
        System.out.println("/comuDetailController.bo  주소 호출");
        action = new comuDetailController();
        try {
            System.out.println("comuDetailController 객체생성완료 후 excute()호출완료");
            forward = action.execute(request, response);
            System.out.println("커뮤니티 게시글 세부내용 컨트롤러 호출 :" + forward);
        } catch (Exception e) {
            e.printStackTrace();
        }
	} //커뮤니티 수정 출력
	else if(command.equals("/comuBoardUpdate.bo")){
		System.out.println("가상주소: /comuBoardUpdate.bo 주소 호출, 실제주소: ./Board/ComuBoard/ComuBoardUpdate/BoardUpdate.jsp");
		forward = new ActionForward();
		forward.setPath("./Board/ComuBoard/ComuBoardUpdate/BoardUpdate.jsp");
		forward.setRedirect(false);
	} //커뮤니티 수정 컨트롤러
	else if(command.equals("/comuUpdateController.bo")){ //주소에 .붙이면 안됨
        System.out.println("/comuUpdateController.bo  주소 호출");
        action = new comuUpdateController();
        try {
            System.out.println("comuUpdateController 객체생성완료 후 excute()호출완료");
            forward = action.execute(request, response);
            System.out.println("커뮤니티 게시글 세부내용 컨트롤러 호출 :" + forward);
        } catch (Exception e) {
            e.printStackTrace();
        }
	} // 커뮤니티 삭제 컨트롤러
	else if(command.equals("/comunityDeleteController.bo")){ //주소에 .붙이면 안됨
        System.out.println("/comunityDeleteController.bo  주소 호출");
        action = new comunityDeleteController();
        try {
            System.out.println("comunityDeleteController 객체생성완료 후 excute()호출완료");
            forward = action.execute(request, response);
            System.out.println("커뮤니티 게시글 삭제 :" + forward);
        } catch (Exception e) {
            e.printStackTrace();
        }
	} // 커뮤니티 댓글 등록 컨트롤러
	else if(command.equals("/comuReplyAddController.bo")){ //주소에 .붙이면 안됨
        System.out.println("/comuReplyAddController.bo  주소 호출");
        action = new comuReplyAddController();
        try {
            System.out.println("comuReplyAddController 객체생성완료 후 excute()호출완료");
            forward = action.execute(request, response);
            System.out.println("커뮤니티 댓글 등록 :" + forward);
        } catch (Exception e) {
            e.printStackTrace();
        }
	} // 커뮤니티 댓글 수정 컨트롤러
	else if(command.equals("/comuReplyUpdateController.bo")){ //주소에 .붙이면 안됨
        System.out.println("/comuReplyUpdateController.bo  주소 호출");
        action = new comuReplyUpdateController();
        try {
            System.out.println("comuReplyUpdateController 객체생성완료 후 excute()호출완료");
            forward = action.execute(request, response);
            System.out.println("커뮤니티 댓글 수정 :" + forward);
        } catch (Exception e) {
            e.printStackTrace();
        }
	} // 커뮤니티 댓글 삭제 컨트롤러
	else if(command.equals("/comuReplyDeleteController.bo")){ //주소에 .붙이면 안됨
        System.out.println("/comuReplyDeleteController.bo  주소 호출");
        action = new comuReplyDeleteController();
        try {
            System.out.println("comuReplyDeleteController 객체생성완료 후 excute()호출완료");
            forward = action.execute(request, response);
            System.out.println("커뮤니티 댓글 삭제 :" + forward);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	//7.페이지이동 : 두가지방식
	//이동정보가 있을때 (ActionForward객체가 생성되었을때) 페이지이동이 실행되어야한다
	//7-1.response => true일때 이동
	//7-2.forward => false일때 이동
	if(forward != null){
		System.out.println("@@@페이지이동@@@");
		if(forward.isRedirect()){//1 - response.sendRedirect(주소)사용
			//정보는 ActionForward객체 안에 있다
			System.out.println("sendRedirect방식의 이동"+forward.getPath());
			response.sendRedirect(forward.getPath());
		}else{ //0 - forward사용
			System.out.println("RequestDispatcher방식의 이동"+forward.getPath());
			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
			dis.forward(request, response);
		}
	}
}

	//2.오버라이딩: doGet(), doPost()
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet메서드 호출");
		doProcess(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost메서드 호출");
		doProcess(request, response);
	}
}
