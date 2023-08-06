package frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberController.MemberJoinController;
import memberController.MemberListController;
import memberController.MemberLoginController;
import memberController.MemberLogoutController;
import model.Action;
import model.ActionForward;

@WebServlet(name = "MemberFrontController", urlPatterns = "*.me")
public class MemberFrontController extends HttpServlet{
	
	
		//3. doProcess()생성
		protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doProcess메서드 호출");
			
			//4. 가상주소 가져오기 : 가지고 다닐 주소는 /*.me 앞부분의 주소는 필요가 없다.
			String requestURI = request.getRequestURI();
			StringBuffer requestURL = request.getRequestURL();
			
			//uri와 url차이 -> uri에서 내 프로젝트명을 뺀 /MemberFrontController만 들고다니면됨
			System.out.println("리퀘스트uri: "+requestURI); ///Study_Platform/*.me
			System.out.println("리퀘스트url: "+requestURL); //http://localhost:8000/*.me
			
			//contextPath는 프로젝트명을 호출함
			String contextPath = request.getContextPath();
			System.out.println("contextPath: " + contextPath); ///Study_Platform
			
			//가상주소: 필요한 주소인 /*.me 만 가져다니기 위해 substring()사용
			String command = requestURI.substring(contextPath.length());
			System.out.println("잘 짤렸는지 가상주소 command: " + command);
			
			//9-1. 일회성이 아닌 다회용 여러번 쓸수있게 처리
			Action action = null;

			//6-3.ActionForward 객체사용
			ActionForward forward = null;
			
			//5. 특정 주소에 대한 처리
			if(command.equals("/MemberJoin.me")){
				System.out.println("/MemberJoin.me 호출");
				
				//6. 회원가입처리 -> 회원정보 입력창(view의 개념이 필요)
				//모델2에서 페이지 이동은 무조건 ActionForward사용
				/*//6-1.페이지이동방법은 2가지 중 첫번째 : response
				response.sendRedirect("./SignUp/Sign_Up.jsp");
				//6-2.페이지이동방법은 2가지 중 두번째 : forward
				RequestDispatcher dis = request.getRequestDispatcher("./SignUp/Sign_Up.jsp");
				dis.forward(request, response);*/

				//6-4. 특정주소에 대한 처리 후 페이지이동  =>먼저 특정주소에 대한 처리는 ActionForward 객체 사용
				//ActionForward 객체 생성되기 전에는 null (값이 없다)이다가 객체생성후 이동정보가 생긴다
				forward = new ActionForward();
				// 이동할 주소
				forward.setPath("./SignUp/Sign_Up.jsp");
				// 이동할 방법
				forward.setRedirect(false);

			//8.MemberJoinController일때도 주소 출력
			//8-1.Action페이지는 모델1의 기능 jsp 페이지 역할을 한다. 
			}else if(command.equals("/MemberJoinController.me")){ //주소에 `.`붙이면 안됨
				System.out.println("/MemberJoinController.me  주소 호출");

				//8-2.전달되는 정보를  Action.java 인터페이스에 저장 --Acttion.java인터페이스와 MemberJoinController.java생성--> DB로 전달
				//Action페이지를 통해서 처리 => MemberJoinAction 객체를 생성 후 execute메서드 호출
				//MemberJoinController action = new MemberJoinController(); //데이터 업캐스팅(Action <- MemberJoinController)해서 저장

				//9-2.`MemberJoinController action = new MemberJoinController()`을 `action = new MemberJoinController();`으로 변경
				action = new MemberJoinController();

				try {
					System.out.println("MemberJoinController 객체생성완료 후 excute()호출완료");
					forward = action.execute(request, response);
					System.out.println("회원가입 처리완료 후 페이지 이동 :" + forward);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//10. 로그인페이지연결
				}else if(command.equals("/MemberLogin.me")){
				System.out.println("가상주소: /MemberLogin.me 주소 호출, 실제주소: ./Main/Main.jsp");
				forward = new ActionForward();
				forward.setPath("./Main/main.jsp");
				forward.setRedirect(false);
				//10-1. 로그인처리
				}else if(command.equals("/MemberLoginController.me")){
				//10-2. MemberLoginAction.java 생성
				action = new MemberLoginController();
				try {
					System.out.println("Controller : MemberLoginController 객체생성완료 후 excute()호출완료");
					forward = action.execute(request, response);
					System.out.println("Controller : 로그인 처리완료 후 페이지 이동 " + forward);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//11.메인페이지 연결
				}else if(command.equals("/Main.me")){
					System.out.println("Controller : 가상주소: /Main.me 실제주소:./MainPage/Class_list.jsp");
					forward = new ActionForward();
					forward.setPath("/lectureListController.lc");
					forward.setRedirect(false);
					try {
						forward = action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				//12. 로그아웃
				}else if(command.equals("/MemberLogout.me")){
					action = new MemberLogoutController();
					try {
						System.out.println("Controller : MemberLogoutController 객체생성완료 후 excute()호출완료");
						forward = action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				//13. 회원 조회 연결
				}else if(command.equals("/MemberList.me")){
					System.out.println("Controller : 가상주소: /MemberList.me 실제주소:./Admin_page/preview/light/memberList.jsp");
					forward = new ActionForward();
					forward.setPath("./Admin_page/preview/light/memberList.jsp");
					forward.setRedirect(false);
					try {
					} catch (Exception e) {
						e.printStackTrace();
					}
				//14. 회원 조회 (어드민 기능)
				}else if(command.equals("/MemberListController.me")){
						action = new MemberListController();
						try {
							System.out.println("Controller : MemberListController 객체생성완료 후 excute()호출완료");
							forward = action.execute(request, response);
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
