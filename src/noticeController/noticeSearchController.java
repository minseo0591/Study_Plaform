package noticeController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.ActionForward;
import notice.notice;
import notice.noticeDAO;

public class noticeSearchController implements Action {
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//1. 한글처리
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
		noticeDAO nodao = new noticeDAO();
		ArrayList<notice> nodto = new ArrayList<>();
		
		int page= 1;
		int limit = 10;
		
		if(request.getParameter("page") != null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		String keyWord = request.getParameter("keyWord");
		String searchWord = request.getParameter("searchWord");
		
		int listSearchCount = nodao.getnoListSearchCount(keyWord, searchWord); 
		nodto = nodao.noticelistSearch(page,limit, keyWord, searchWord); 	// 게시물을 LIST 객체에 담습니다. 
		
		
		// 최대 페이지를 구합니다.
   		int maxpage = (int)((double)listSearchCount / limit + 0.95); // 0.95 올림처리
   		
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
		request.setAttribute("count",listSearchCount); 		// 게시물 총 개수
		request.setAttribute("keyWord", keyWord);
		request.setAttribute("searchWord", searchWord);
		
		
		
		
		request.setAttribute("nolist", nodto);
		
		//4. 페이지이동 : 무조건 Controller로 이동
		System.out.println("lectureSearchController : 페이지이동");
		ActionForward forward = new ActionForward();
		forward.setPath("noticeList.nc");
		forward.setRedirect(false);
		return forward;
	}
}
