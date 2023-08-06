package lectureController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.CommentDAO;
import lecture.lecture;
import lecture.lectureDAO;
import model.Action;
import model.ActionForward;

public class lectureCommentAddController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		int lec_id = Integer.parseInt(request.getParameter("lec_id"));
		String stu_id = request.getParameter("id");
		String rating = request.getParameter("rating");
		String text = request.getParameter("tess");
		CommentDAO cmdao = new CommentDAO();
		cmdao.insertCo(lec_id, text, rating, stu_id);
		cmdao.updateReply(lec_id);
		cmdao.updateStar(lec_id);
		
//		lectureDAO lcdao = new lectureDAO();
//		lecture lecture = lcdao.getClassPage(lec_id);
		
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("lectureDetailController.lc?lec_id="+lec_id);
		request.setAttribute("test", "asssssss");
		forward.setRedirect(true);
		return forward;
	}

}
