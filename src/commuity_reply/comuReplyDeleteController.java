package commuity_reply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Action;
import model.ActionForward;

public class comuReplyDeleteController implements Action {

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
		System.out.println("게시글 번호 : " + comuNum);
		comuReplyDAO crd = new comuReplyDAO();
		//2.댓글 update 객체
		int level = Integer.parseInt(request.getParameter("level"));
		//조건문 보고 insert만들기.
		crd.DeleteReply(comuNum, seid, level);
//		crd.listupdateReply(comuNum);
		
		ActionForward forward = new ActionForward();
		forward.setPath("comuDetailController.bo?number="+comuNum);
		forward.setRedirect(true);
		return forward;
	}

}
