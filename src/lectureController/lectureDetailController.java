package lectureController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.Comment;
import comment.CommentDAO;
import lecture.leccm;
import lecture.lecture;
import lecture.lectureDAO;
import model.Action;
import model.ActionForward;

public class lectureDetailController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("lectureDetailController안의 execute() 실행됨");
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		int lec_id = Integer.parseInt(request.getParameter("lec_id"));
		CommentDAO cd = new CommentDAO();

		System.out.println("id값 출력 :" + lec_id);
		
		//3.DAO객체 생성하여 DB정보가져오기
		lectureDAO lcdao = new lectureDAO();
		leccm leccm = lcdao.getClassPage(lec_id);
		
		//세부사항 강의 이름
		ArrayList<String> ac = new ArrayList<String>();
		ac.addAll(leccm.getArrayTitle());
		//댓글
		CommentDAO cmdao = new CommentDAO();
		ArrayList<Comment> s1 = cmdao.getss(lec_id);
		
        System.out.println("받아온 값 : " + s1);

      //별의 평균 합계  퍼센트
        		int StarCount = cmdao.getStarCount(lec_id);
                int StarSum = cmdao.getSumStar(lec_id);
                int one = cmdao.getPer(lec_id, 1);
                int two = cmdao.getPer(lec_id, 2);
                int three = cmdao.getPer(lec_id, 3);
                int four = cmdao.getPer(lec_id, 4);
                int five= cmdao.getPer(lec_id, 5);


                int avg=0;

                if(StarCount==0) {
                    avg=0;
                }else {
                    avg = StarSum/StarCount;
                }

                double percentone=((double) one/(double)StarCount*100.0);
                double percenttwo=((double) two/(double)StarCount*100.0);
                double percentthree=((double) three/(double)StarCount*100.0);
                double percentfour=((double) four/(double)StarCount*100.0);
                double percentfive=((double) five/(double)StarCount*100.0);
        
		//2-1.id값이 없으면 강의 목록 페이지로 이동
		ActionForward forward = new ActionForward();
		/*
		 * if(lec_id == 0){ forward.setPath("./lectureList.me");
		 * forward.setRedirect(true); //주소가 바뀌니까 false가 아니라 true임 return forward; //아이디가
		 * 없으면 retrun을 통해서 아래 코드는 실행되지않는다. }
		 */
		 
		
		//4. .java --request객체로 데이터를 전달--> .jsp
		
		request.setAttribute("lecture", leccm);
		request.setAttribute("test", ac);
		request.setAttribute("s1", s1);
		
		request.setAttribute("StarCount", StarCount);
        request.setAttribute("avg",avg);
        request.setAttribute("percentone", percentone);
        request.setAttribute("percenttwo", percenttwo);
        request.setAttribute("percentthree", percentthree);
        request.setAttribute("percentfour", percentfour);
        request.setAttribute("percentfive", percentfive);
		forward.setPath("lectureDetail.lc");
		forward.setRedirect(false);
		return forward;
	}

}
