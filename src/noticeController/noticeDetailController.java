package noticeController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.ActionForward;
import notice.notice;
import notice.noticeDAO;

public class noticeDetailController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		int no_id = Integer.parseInt(request.getParameter("no_id"));
				
		
		noticeDAO nodao = new noticeDAO();
		notice nodto = nodao.getNoticePage(no_id);
		
		ActionForward forward = new ActionForward();

		request.setAttribute("noticeDe", nodto);
		
		forward.setPath("noticeDetail.nc");
		forward.setRedirect(false);
		return forward;
				
	}
}
