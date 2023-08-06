package frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Video.Vmap;
import model.Action;
import model.ActionForward;

@WebServlet(name="VideoForntController", urlPatterns ="*.vc")
public class VideoForntController extends HttpServlet {
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
	
	//동영상 출력 및 수강신청 기능 컨트롤러
	if(command.equals("/Vmap.vc")){ //주소에 .붙이면 안됨
        System.out.println("/Vmap.vc  주소 호출");
        action = new Vmap();
        try {
            System.out.println("Vmap 객체생성완료 후 excute()호출완료");
            forward = action.execute(request, response);
            System.out.println("동영상 링크 클릭시 페이지 이동 :" + forward);
        } catch (Exception e) {
            e.printStackTrace();
        }
	} //동영상 플레이어 출력 
	else if(command.equals("/video.vc")){
		System.out.println("가상주소: /video.vc 주소 호출, 실제주소: ./Video_Player/video_player.jsp");
		forward = new ActionForward();
		forward.setPath("./Video_Player/video_player.jsp");
		forward.setRedirect(false);
	}
	
	
	//7.페이지이동 : 두가지방식
	//이동정보가 있을때 (ActionForward객체가 생성되었을때) 페이지이동이 실행되어야한다
	//7-1.response => true일때 이동
	//7-2.forward => false일때 이동
	if (forward != null) {
		System.out.println("@@@페이지이동@@@");
		if (forward.isRedirect()) {// 1 - response.sendRedirect(주소)사용
			// 정보는 ActionForward객체 안에 있다
			System.out.println("sendRedirect방식의 이동" + forward.getPath());
			response.sendRedirect(forward.getPath());
		} else { // 0 - forward사용
			System.out.println("RequestDispatcher방식의 이동" + forward.getPath());
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
