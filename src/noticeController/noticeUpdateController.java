package noticeController;



import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.ActionForward;
import notice.notice;
import notice.noticeDAO;

public class noticeUpdateController implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		int no_id = Integer.parseInt(request.getParameter("no_id"));
		
		noticeDAO nodao = new noticeDAO();
		notice nodto = new notice();
		nodto.setNo_id(no_id);
		nodto.setAdmin_id(request.getParameter("admin_id"));
		nodto.setNo_title(request.getParameter("upd_title"));
		String aa = request.getParameter("upd_date");
		java.sql.Date saaa= java.sql.Date.valueOf(aa);
		nodto.setNo_date(saaa);
		nodto.setNo_content(request.getParameter("upd_content"));

		
		nodao.Updatenotice(nodto);
		
		

	
		ActionForward forward = new ActionForward();

		request.setAttribute("noticeDe", nodto);
		
		forward.setPath("noticeDetail.nc");
		forward.setRedirect(false);
		return forward;
				
	}
	
}
