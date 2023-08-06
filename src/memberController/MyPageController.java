package memberController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Action;
import model.ActionForward;
import sugang.Sugang;
import sugang.SugangDAO;
import sugang.sugangdoneDAO;

public class MyPageController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String stu_id = (String) session.getAttribute("id"); //유저 아이디 
		
		//수강 dao 호출
		SugangDAO sd = new SugangDAO();
		sugangdoneDAO sdd = new sugangdoneDAO();
		//수강 모델 호출
		Sugang sg = new Sugang();
		//수강내역
		ArrayList<Sugang> sugangarray = sd.getleclist(stu_id);
		request.setAttribute("sugangarray", sugangarray);
		//최근 시청한 강의 - 강의번호, 제목, 날짜
		request.setAttribute("last_lecid", sd.getLastId(stu_id));
		request.setAttribute("last_title", sd.getLastTitle(stu_id));
		request.setAttribute("last_date",  sd.getLastDate(stu_id));
		//수강한 강의의 총 수 
		request.setAttribute("mysugangcount", sd.getmylecturecount(stu_id));
		//등록한 리뷰 수
		request.setAttribute("mycommentcount", sd.getmycommentcount(stu_id));
		//수강완료 수
		request.setAttribute("mydonecount", sdd.getDoneCount(stu_id));
		
		ActionForward forward = new ActionForward();
        forward.setPath("MyPage.lc");
        forward.setRedirect(false);
        return forward;
	}

}
