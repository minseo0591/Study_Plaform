package noticeController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.ActionForward;
import notice.notice;
import notice.noticeDAO;


public class noticeListController implements Action {

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		noticeDAO nodao = new noticeDAO();
		ArrayList<notice> nodto =new ArrayList<>();
		String PageNum=request.getParameter("PageNum");
		int page =1;
		int limit =10;
		
		// 사용자의 요청(request)을 통해 "page" 파라미터가 있는 확인
		if(request.getParameter("page") != null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount = nodao.getNoListCount();
		nodto = nodao.noClasslist(page, limit);
		
		//최대 페이지를 구한다.
		int maxpage= (int)((double)listcount/limit+0.95);
		//시작 페이지를 구한다.
		int startpage = (((int)((double)page / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = maxpage;
   		if(endpage > startpage + 10 - 1) endpage = startpage + 10 - 1;
		
   		System.out.println("page :" + page);
		System.out.println("maxpage :" + maxpage);
		System.out.println("startpage :" + startpage);
		System.out.println("endpage :" + endpage);
		System.out.println("count :" + listcount);
		System.out.println("page :" + page);
		System.out.println("limit :" + limit);
   		
   		
   		request.setAttribute("page", page);           //현재 페이지 
   		request.setAttribute("maxpage", maxpage); 		// 최대 페이지
   		request.setAttribute("startpage", startpage); 	// 시작 페이지
   		request.setAttribute("endpage", endpage);     	// 마지막 페이지
		request.setAttribute("count",listcount); 		// 게시물 총 개수
		
		request.setAttribute("nolist", nodto);
		
		System.out.println("noticeListController : 페이지이동");
		ActionForward forward = new ActionForward();
		forward.setPath("noticeList.nc");
		forward.setRedirect(false);
		return forward;
	}
}
