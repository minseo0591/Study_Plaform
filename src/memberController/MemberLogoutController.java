package memberController;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Action;
import model.ActionForward;

public class MemberLogoutController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberLogoutController안의 execute() 실행됨");
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		
		//2.세션초기화
		HttpSession session = request.getSession(); 
		session.invalidate();
		
		//3. 메인페이지이동 : 결과에 따른 페이지이동처리,  무조건 Controller로 이동
		System.out.println("로그아웃성공 후 페이지이동 ");		
		
		//자바스크립트사용하여 alert()창띄우기
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('정상적으로 로그아웃 되었습니다');");
		out.print("location.href='./MemberLogin.me';");
		out.print("</script>");
		
		//자원해제
		out.close();
		return null;
	}

}
