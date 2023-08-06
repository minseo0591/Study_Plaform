package community;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import commuity_reply.comuReply;
import commuity_reply.comuReplyDAO;
import model.Action;
import model.ActionForward;

public class comuDetailController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("communityListController안의 execute() 실행됨");
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//접속한 사용자 아이디.(댓글쓸려고)
		HttpSession session = request.getSession();
		String seid = (String) session.getAttribute("id");
		
		//게시판 작성자 아이디.
		int comuNum = Integer.parseInt(request.getParameter("number"));
		request.setAttribute("comuNum", comuNum);
		
		System.out.println("커뮤니티 세부사항으로 넘겨받은 값 : " + comuNum);
		//세부사항 리스트 뽑기
		ArrayList<comu> dtlist = new ArrayList<comu>();
		comuDetailDAO cdd = new comuDetailDAO();
		dtlist = cdd.getDetailList(comuNum);
		request.setAttribute("dtlist", dtlist);
		//글주인
		String ids = cdd.getStu_id(comuNum);
		request.setAttribute("ids", ids);
		//수정
		
		//삭제
		
		//댓글
		//1.댓글 리스트 뽑는 객체 사용자id와 내용 날짜를 리턴하자
		comuReplyDAO crd = new comuReplyDAO();
		ArrayList<comuReply> replyList = crd.getComuReplyList(comuNum);
		request.setAttribute("replyList", replyList);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("comuBoardDetail.bo");
		forward.setRedirect(false);
		return forward;
	}

}
