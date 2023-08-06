package frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Video.Vmap;
import commuity_reply.comuReplyAddController;
import commuity_reply.comuReplyDeleteController;
import commuity_reply.comuReplyUpdateController;
import community.communityListController;
import community.comuAddController;
import community.comuDetailController;
import community.comuSearchController;
import community.comuUpdateController;
import community.comunityDeleteController;
import lectureController.lectureCategoryController;
import lectureController.lectureCommentAddController;
import lectureController.lectureDetailController;
import lectureController.lectureJoinController;
import lectureController.lectureListController;
import lectureController.lectureSearchController;
import memberController.MyPageController;
import model.Action;
import model.ActionForward;

@WebServlet(name = "lectureFrontController", urlPatterns = "*.lc")
@MultipartConfig(fileSizeThreshold = 1024*1024,
maxFileSize = 1024*1024*50, //50메가
maxRequestSize = 1024*1024*50*5, // 50메가 5개까지 
location="C:/Users/minse/Desktop/aa")
public class lectureFrontController extends HttpServlet{
		
		private ServletContext ctx;
	
		public void init(ServletConfig config) throws ServletException {
				super.init(config);
				ctx = getServletContext();		
		}
		
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
			
			//5. 특정 주소에 대한 처리
			//강의 등록 페이지
			if(command.equals("/ClassAdd.lc")){
				System.out.println("/ClassAdd.lc 호출");
				forward = new ActionForward();
				// 이동할 주소
				forward.setPath("./Admin_page/preview/light/class_add.jsp");
				// 이동할 방법
				forward.setRedirect(false);
			//lectureJoinController 강의 등록 처리 페이지
			//Controller페이지는 모델1의 기능 jsp 페이지 역할을 한다. 
			}else if(command.equals("/lectureJoinController.lc")){ //주소에 `.`붙이면 안됨
				System.out.println("/lectureJoinController.lc  주소 호출");
				action = new lectureJoinController();
				try {
					System.out.println("lectureJoinController 객체생성완료 후 excute()호출완료");
					forward = action.execute(request, response);
					System.out.println("강의 등록 처리완료 후 페이지 이동 :" + forward);
				} catch (Exception e) {
					e.printStackTrace();
				}
				 //강의 목록 값 가져오기
				}else if(command.equals("/lectureListController.lc")){ //주소에 `.`붙이면 안됨
					System.out.println("/lectureListController.lc  주소 호출");
					action = new lectureListController();
					try {
						System.out.println("lectureListController 객체생성완료 후 excute()호출완료");
						forward = action.execute(request, response);
						System.out.println("강의 값 가져온 후 처리완료 후 페이지 이동 :" + forward);
					} catch (Exception e) {
						e.printStackTrace();
					}
				 //강의 목록 연결
				}else if(command.equals("/lectureList.lc")){
					System.out.println("가상주소: /lectureList.lc 주소 호출, 실제주소: ./MainPage/Class_list.jsp");
					forward = new ActionForward();
					forward.setPath("./MainPage/Class_list.jsp");
					forward.setRedirect(false);
				}
				 //강의 세부사항 값 가져오기
				else if(command.equals("/lectureDetailController.lc")){ //주소에 `.`붙이면 안됨
					System.out.println("/lectureDetailController.lc  주소 호출");
					action = new lectureDetailController();
					try {
						System.out.println("lectureDetailController 객체생성완료 후 excute()호출완료");
						forward = action.execute(request, response);
						System.out.println("강의 세부 값 가져온 후 처리완료 후 페이지 이동 :" + forward);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} //강의 세부 연결
				else if(command.equals("/lectureDetail.lc")){
					System.out.println("가상주소: /lectureDetail.lc 주소 호출, 실제주소: ./LecturePages/lecture-intro.jsp");
					forward = new ActionForward();
					forward.setPath("./LecturePages/lecture-intro.jsp");
					forward.setRedirect(false);
				} //강의 세부 댓글
				else if(command.equals("/lectureCommentAddController.lc")){ //주소에 .붙이면 안됨
                    System.out.println("/lectureCommentAddController.lc  주소 호출");
                    action = new lectureCommentAddController();
                    try {
                        System.out.println("lectureCommentAddController 객체생성완료 후 excute()호출완료");
                        forward = action.execute(request, response);
                        System.out.println("강의 댓글 정보 입력 :" + forward);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
				}  //강의 목록 검색
				else if(command.equals("/lectureSearchController.lc")){ //주소에 .붙이면 안됨
                    System.out.println("/lectureSearchController.lc  주소 호출");
                    action = new lectureSearchController();
                    try {
                        System.out.println("lectureSearchController 객체생성완료 후 excute()호출완료");
                        forward = action.execute(request, response);
                        System.out.println("강의 목록 검색 정보 :" + forward);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
				} //강의 목록 카테고리
				else if(command.equals("/lectureCategoryController.lc")){ //주소에 .붙이면 안됨
                    System.out.println("/lectureCategoryController.lc  주소 호출");
                    action = new lectureCategoryController();
                    try {
                        System.out.println("lectureCategoryController 객체생성완료 후 excute()호출완료");
                        forward = action.execute(request, response);
                        System.out.println("강의 목록 카테고리 정보 :" + forward);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
				} //마이페이지 출력
				else if(command.equals("/MyPage.lc")){
					System.out.println("가상주소: /Mypage.lc 주소 호출, 실제주소: ./MemPage/Member_Dashboard/member_Dashboard.jsp");
					forward = new ActionForward();
					forward.setPath("./MemPage/Member_Dashboard/member_Dashboard.jsp");
					forward.setRedirect(false);
				} //마이페이지 컨트롤러
				else if(command.equals("/MyPageController.lc")){ //주소에 .붙이면 안됨
                    System.out.println("/MyPageController.lc  주소 호출");
                    action = new MyPageController();
                    try {
                        System.out.println("MyPageController 객체생성완료 후 excute()호출완료");
                        forward = action.execute(request, response);
                        System.out.println("마이페이지 대시보드 정보 :" + forward);
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
