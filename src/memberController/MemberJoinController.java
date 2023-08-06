package memberController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Member;
import member.MemberDAO;
import model.Action;
import model.ActionForward;



public class MemberJoinController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberJoinAction안의 execute() 실행됨");
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		
		//2.전달되는 파라미터 정보저장 ->Member 생성
		Member mb = new Member();
		mb.setStu_id(request.getParameter("stu_id"));
		mb.setStu_pwd(request.getParameter("stu_pwd"));
		mb.setStu_name(request.getParameter("stu_name"));
		//시간은 파라미터가 아닌 현재시간으로 저장
		System.out.println("MemberJoinController : 전달받은 정보 Member 객체 확인 :" + mb.toString());
		
		//3. DB객체처리
		MemberDAO mdao = new MemberDAO();
		mdao.insertMember(mb);
		System.out.println("MemberJoinController : 디비작업처리완료");
		
		//4. 페이지이동 : 무조건 Controller로 이동
		System.out.println("@@@@ Action : 페이지이동");
		ActionForward forward = new ActionForward();
		forward.setPath("./MemberLogin.me");
		forward.setRedirect(true);
		return forward;
	}
}
