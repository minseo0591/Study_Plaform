package memberController;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.Member;
import member.MemberDAO;
import model.Action;
import model.ActionForward;

public class MemberLoginController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberLoginController안의 execute() 실행됨");
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		// 2.전달되는 파라미터 정보저장 ->MemberLoginController객체생성
		Member mb = new Member();
		mb.setStu_id(request.getParameter("stu_id"));
		mb.setStu_pwd(request.getParameter("stu_pwd"));
		
		// 3. DB객체처리
		MemberDAO mdao = new MemberDAO();
		int check = mdao.idCheack(mb);
		
		// 4. 페이지이동 : 결과에 따른 페이지이동처리
		System.out.println("페이지이동 : " + check);
		
		//4-2.로그인 비번오류
		if(check == 0){ //로그인 비번오류
			//자바스크립트사용하여 alert()창띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('비밀번호가 틀렸습니다.');");
			out.print("history.back();");
			out.print("</script>");
			//자원해제
			out.close();
			return null; //null이란 Controller에서 페이지 이동하지않겠다는  의미
		}else if(check == -1){
			//자바스크립트사용하여 alert()창띄우기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('존재하지 않는 아이디입니다.');");
			out.print("history.back();");
			out.print("</script>");
			//자원해제
			out.close();
			return null; //null이란 Controller에서 페이지 이동하지않겠다는  의미			
		}
		
		//4-1. 정상 로그인처리
		if (check == 1){ //정상 로그인처리
			//아이디값 세션객체에 저장
			//jsp페이지가 아닌 java페이지기때문에 java에는 session내장객체가 없다.
			//session.setAttribute("id", id); 한줄로는 실행이 안되니까 HttpSession session = req.getSession(); 추가해준다
			HttpSession session = request.getSession();
			session.setAttribute("id", mb.getStu_id());
		}
		
		//페이지이동객체생성
		ActionForward forward = new ActionForward();
		forward.setPath("./Main.me");
		forward.setRedirect(true);			
		return forward;
	}

}
