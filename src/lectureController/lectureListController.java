package lectureController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.lecture;
import lecture.lectureDAO;
import model.Action;
import model.ActionForward;

public class lectureListController implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("lectureListController안의 execute() 실행됨");
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		lectureDAO lcdao = new lectureDAO();
		ArrayList<lecture> lcdto = new ArrayList<>();
		String PageNum = request.getParameter("PageNum");
		
		int page = 1;	// 기본 페이지
		int limit = 16; // 최대 페이지
		
		// 사용자의 요청(request)을 통해 "page" 파라미터가 있는 확인
		if(request.getParameter("page") != null){
			page=Integer.parseInt(request.getParameter("page"));
		}
				
		int listcount = lcdao.getListCount(); 
		lcdto = lcdao.Classlist(page,limit); 	// 게시물을 LIST 객체에 담습니다. 
		
		// 최대 페이지를 구합니다.
   		int maxpage = (int)((double)listcount / limit + 0.95); // 0.95 올림처리
   		
   		// 시작 페이지를 구합니다. ex ) start page count(1, 11, 21...)
   		int startpage = (((int)((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		
   		// 마지막 페이지를 구합니다. ex ) last page count(10, 20, 30...)
   		int endpage = maxpage;
   		if(endpage > startpage + 10 - 1) endpage = startpage + 10 - 1;
   		
   		// JSP에 값을 넘겨주기 위하여 세팅
   		request.setAttribute("page", page);		  		// 현재 페이지
   		request.setAttribute("maxpage", maxpage); 		// 최대 페이지
   		request.setAttribute("startpage", startpage); 	// 시작 페이지
   		request.setAttribute("endpage", endpage);     	// 마지막 페이지
		request.setAttribute("count",listcount); 		// 게시물 총 개수
		
		System.out.println("page :" + page);
		System.out.println("maxpage :" + maxpage);
		System.out.println("startpage :" + startpage);
		System.out.println("endpage :" + endpage);
		System.out.println("count :" + listcount);
		System.out.println("page :" + page);
		System.out.println("limit :" + limit);
		
		//3. DB객체처리
		
		request.setAttribute("classlist", lcdto);
		System.out.println("lectureListController : 디비작업처리완료");
		
		//4. 페이지이동 : 무조건 Controller로 이동
		System.out.println("lectureListController : 페이지이동");
		ActionForward forward = new ActionForward();
		forward.setPath("lectureList.lc");
		forward.setRedirect(false);
		return forward;
	}
}
