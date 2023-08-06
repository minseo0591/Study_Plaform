package noticeController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.ActionForward;
import notice.notice;
import notice.noticeDAO;

public class noticeDeleteController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		int no_id = Integer.parseInt(request.getParameter("no_id"));
		
		noticeDAO nodao = new noticeDAO();
		notice nodto = new notice();
		
		nodto.setNo_id(no_id);
		nodao.Deletenotice(nodto);
		
		
		
		
		
		
		ActionForward forward = new ActionForward();

		
		forward.setPath("noticeListController.nc?page=1");
		forward.setRedirect(true);
		return forward;

	}

}
