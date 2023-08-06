package frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.ActionForward;
import noticeController.noticeDeleteController;
import noticeController.noticeDetailController;
import noticeController.noticeInsertController;
import noticeController.noticeListController;
import noticeController.noticeSearchController;
import noticeController.noticeUpdateController;
import noticeController.noticeUpdateViewController;


@WebServlet(name="NoticeFrontController", urlPatterns ="*.nc")
public class NoticeFrontController extends HttpServlet {

    private ServletContext ctx;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ctx = getServletContext();		
	}

	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("doProcess메서드 호출");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
    	
    	//4. 가상주소 가져오기 : 가지고 다닐 주소는 /*.lc 앞부분의 주소는 필요가 없다.
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		
		
		//uri와 url차이 -> uri에서 내 프로젝트명을 뺀 /lectureFrontController만 들고다니면됨
		System.out.println("리퀘스트uri: "+requestURI); ///Study_Platform/*.nc
		System.out.println("리퀘스트url: "+requestURL); //http://localhost:8000/*.nc
		
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
		
		if(command.equals("/NoticeAdd.nc")){
			System.out.println("/NoticeAdd.nc 호출");
			forward = new ActionForward();
			// 이동할 주소
			forward.setPath("./Notice/noticeWrite/noticeWrite.jsp");
			// 이동할 방법
			forward.setRedirect(false);
		//lectureJoinController 강의 등록 처리 페이지
		//Controller페이지는 모델1의 기능 jsp 페이지 역할을 한다. 
		} else if(command.equals("/noticeInsertController.nc")){ //주소에 `.`붙이면 안됨
			System.out.println("/noticeInsertController.nc 주소 호출");
			action = new noticeInsertController();
			try {
				System.out.println("noticeInsertController 객체생성완료 후 excute()호출완료");
				forward = action.execute(request, response);
				System.out.println("강의 등록 처리완료 후 페이지 이동 :" + forward);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//강의 목록 값 가져오기
			}else if(command.equals("/noticeListController.nc")) {
			action = new noticeListController();
			try {
				System.out.println("noticeListController 객체생성완료 후 excute()호출완료");
				forward = action.execute(request, response);
				System.out.println("강의 값 가져온 후 처리완료 후 페이지 이동 :" + forward);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/noticeList.nc")) {
			forward = new ActionForward();
			forward.setPath("./Notice/NoticeList/Notice_list.jsp");
			forward.setRedirect(false);
		}//공지사항 세부사항 값 가져오기
		else if(command.equals("/noticeDetailController.nc")){ //주소에 `.`붙이면 안됨
			System.out.println("/noticeDetailController.nc  주소 호출");
			action = new noticeDetailController();
			try {
				System.out.println("noticeDetailController 객체생성완료 후 excute()호출완료");
				forward = action.execute(request, response);
				System.out.println("강의 세부 값 가져온 후 처리완료 후 페이지 이동 :" + forward);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//공지사항  세부 연결
		else if(command.equals("/noticeDetail.nc")){
			System.out.println("가상주소: /noticeDetail.nc 주소 호출, 실제주소: ./LecturePages/lecture-intro.jsp");
			forward = new ActionForward();
			forward.setPath("./Notice/NoticeList/NoticeView.jsp");
			forward.setRedirect(false);
		}//공지사항 세부사항 수정하 가져오기
		else if(command.equals("/noticeUpdateViewController.nc")){ //주소에 `.`붙이면 안됨
			System.out.println("/noticeUpdateViewController.nc  주소 호출");
			action = new noticeUpdateViewController();
			try {
				System.out.println("noticeUpdateViewController 객체생성완료 후 excute()호출완료");
				forward = action.execute(request, response);
				System.out.println("강의 세부 값 가져온 후 처리완료 후 페이지 이동 :" + forward);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/noticeUpdate.nc")){
			System.out.println("가상주소: /noticeUpdate.nc 주소 호출, 실제주소: ./LecturePages/lecture-intro.jsp");
			forward = new ActionForward();
			forward.setPath("./Notice/NoticeList/NoticeUpdate.jsp");
			forward.setRedirect(false);
		}//공지사항 세부사항 수정하기 
		else if(command.equals("/noticeUpdateController.nc")){ //주소에 `.`붙이면 안됨
			System.out.println("/noticeUpdateController.nc  주소 호출");
			action = new noticeUpdateController();
			try {
				System.out.println("noticeUpdateController 객체생성완료 후 excute()호출완료");
				forward = action.execute(request, response);
				System.out.println("강의 세부 값 가져온 후 처리완료 후 페이지 이동 :" + forward);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//공지사항 삭제하기 
		else if(command.equals("/noticeDeleteController.nc")){ //주소에 `.`붙이면 안됨
			System.out.println("/noticeDeleteController.nc  주소 호출");
			action = new noticeDeleteController();
			try {
				System.out.println("noticeDeleteController 객체생성완료 후 excute()호출완료");
				forward = action.execute(request, response);
				System.out.println("강의 세부 값 가져온 후 처리완료 후 페이지 이동 :" + forward);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//공지사항  목록 검색
		else if(command.equals("/noticeSearchController.nc")){ //주소에 .붙이면 안됨
            System.out.println("/noticeSearchController.nc주소 호출");
            action = new noticeSearchController();
            try {
                System.out.println("/noticeSearchController.nc 객체생성완료 후 excute()호출완료");
                forward = action.execute(request, response);
                System.out.println("강의 목록 검색 정보 :" + forward);
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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("doGet메서드 호출");
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost메서드 호출");
		doProcess(request, response);
	}

}
