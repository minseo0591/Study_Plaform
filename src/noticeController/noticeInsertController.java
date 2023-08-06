package noticeController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Action;
import model.ActionForward;
import notice.notice;
import notice.noticeDAO;

public class noticeInsertController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 notice no = new notice();
		 no.setNo_title(request.getParameter("no_title"));
		 no.setNo_content(request.getParameter("no_content"));
		 HttpSession session = request.getSession();
		 String aa = (String) session.getAttribute("id");
		 no.setAdmin_id(aa);
		 
		noticeDAO nodao= new noticeDAO();
		nodao.insertnotice(no);
		System.out.println("no_title은 무엇? "+no.getNo_title());
		
	
		
		
		
		
		//4. 페이지이동 : 무조건 Controller로 이동
				System.out.println("noticeInsertController : 페이지이동");
				ActionForward forward = new ActionForward();
				forward.setPath("noticeListController.nc");
				forward.setRedirect(true);
				return forward;
		
	}
	
	
	
	
	
	
	
}
