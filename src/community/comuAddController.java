package community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Action;
import model.ActionForward;

public class comuAddController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String stu_id = (String) session.getAttribute("id"); //유저 아이디 
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		
		System.out.println("id : " + stu_id);
		System.out.println("comment : " + content);
		System.out.println("title : " + title);
		//제목과 내용을 받고, 날짜 추가해서 insert 하기. 완료시 자동으로 목록으로 돌아간다. 
		
		comuAddDAO cad = new comuAddDAO();
		cad.comuAdd(title, stu_id, content);
		
		ActionForward forward = new ActionForward();
		forward.setPath("communityListController.bo");
		forward.setRedirect(true);
		return forward;
	}

}
