package community;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.ActionForward;

public class comuUpdateController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("comuUpdateController안의 execute() 실행됨");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//값 전달.
		String stu_id = request.getParameter("ids");
		int comuNum = Integer.parseInt(request.getParameter("number"));
		System.out.println("커뮤니티 세부사항에서 수정하려고 넘겨받은 값 : " + stu_id + " " + comuNum);
		
		//변경할 값 받기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("title과 content : " + title + content);
		//업데이트 하기 !!
		comuUpdateDAO cud = new comuUpdateDAO();
		if(title != null) {
			cud.updateDate(title, content, comuNum, stu_id);
			System.out.println("수정 되었습니다.");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('수정되었습니다!!');");
			out.print("history.back();");
			out.print("</script>");
			//자원해제
			out.close();
		}
		else {
			
		}
		ArrayList<comu> dtlist = new ArrayList<comu>();
		comuDetailDAO cdd = new comuDetailDAO();
		dtlist = cdd.getDetailList(comuNum);
		request.setAttribute("dtlist", dtlist);
		
		ActionForward forward = new ActionForward();
		forward.setPath("comuBoardDetail.bo");
		forward.setRedirect(false);
		return forward;
	}

}
