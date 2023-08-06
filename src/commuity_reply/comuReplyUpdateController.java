package commuity_reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Action;
import model.ActionForward;

public class comuReplyUpdateController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("communityListController안의 execute() 실행됨");
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//접속한 사용자 아이디.(댓글쓸려고)
		HttpSession session = request.getSession();
		String seid = (String) session.getAttribute("id");
		
		int comuNum = Integer.parseInt(request.getParameter("number"));
		request.setAttribute("comuNum", comuNum);
		
		comuReplyDAO crd = new comuReplyDAO();
		//2.댓글 update 객체
		String reply_contents = request.getParameter("reUpcontents");
		System.out.println("넘어온 값: " + reply_contents);
		int level = Integer.parseInt(request.getParameter("level"));
		//조건문 보고 insert만들기.
		crd.updateReply(reply_contents, comuNum, seid, level);
		
		ActionForward forward = new ActionForward();
		forward.setPath("comuDetailController.bo?number="+comuNum);
		forward.setRedirect(true);
		return forward;
	}

}
