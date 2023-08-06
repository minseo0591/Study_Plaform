package community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.ActionForward;

public class comunityDeleteController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("number"));
		comuDAO cmd = new comuDAO();
		cmd.Deletenotice(num);
		
		ActionForward forward = new ActionForward();


        forward.setPath("communityListController.bo");
        forward.setRedirect(true);
        return forward;
	}

}
