package Video;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture.lecture;
import member.Member;
import model.Action;
import model.ActionForward;
import sugang.Sugang;
import sugang.SugangDAO;
import sugang.sugangdoneDAO;

public class Vmap implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int lec_id = Integer.parseInt(request.getParameter("lec_id"));
		int level = Integer.parseInt(request.getParameter("level"));
		int check = 0;
		if(request.getParameter("check") == null) {
			check = 0;
		}
		else {
			check = 1;
		}
		
		HttpSession session = request.getSession();
		String stu_id = (String) session.getAttribute("id"); //유저 아이디 
		String lec_title = request.getParameter("lec_title");
		System.out.println("유저 아이디 : " + stu_id + " 수강타이틀 : " + lec_title);
		SugangDAO sugangdao = new SugangDAO();
		//if문으로 이미 lec_id가 있으면 등록 안되게 해야함.
		boolean sugangchecks = sugangdao.ischecksugang(stu_id, lec_id);
		System.out.println("수강신청 여부 : " +  sugangchecks);
		if(!sugangchecks) {
			Sugang sugang = new Sugang(stu_id, lec_id, lec_title);
			sugangdao.insertMember(sugang);
			
		}
		else {
			System.out.println("이미 수강한 강의 입니다!!");
		}
		
		//수강 완료 확인(중복 등록 방지)
		sugangdoneDAO sdd = new sugangdoneDAO();
		boolean donecheck = sdd.ischecksugangdone(stu_id, lec_id);
		System.out.println("수강완료 여부 : " + donecheck);
		if(check == 1) {
			if(donecheck == false) {
				sdd.insertDone(stu_id, lec_id, check);
				System.out.println("수강완료 되었습니다.");
			}
			else {
				System.out.println("이미 수강완료 된 강의입니다.");
			}
		}
		
		
		
		
		//수강비디오 코드
		ArrayList<VideoDTO> video1 = new ArrayList<VideoDTO>();
        VideoDAO vd = new VideoDAO();
        video1 = vd.getAllCM(lec_id);

        int maxlevel = vd.getLevelCount(lec_id);

        String videoUrl = null;
        if(level == 1 ) {
            videoUrl = vd.getUrl(lec_id, 1);
        }
        else {
            videoUrl = vd.getUrl(lec_id, level);
        }
        String ch_title = vd.getTitle(lec_id, level);

        //수강신청 DAO활용
        

        ActionForward forward = new ActionForward();
        request.setAttribute("videos", video1);
        request.setAttribute("videoUrl", videoUrl);
        request.setAttribute("levels", level);
        request.setAttribute("maxlevel", maxlevel);
        request.setAttribute("lec_id", lec_id);
        request.setAttribute("ch_title", ch_title);
        forward.setPath("video.vc");
        forward.setRedirect(false);
        return forward;
	}

}
