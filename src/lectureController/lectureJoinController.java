package lectureController;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import lecture.cm;
import lecture.lecture;
import lecture.lectureDAO;
import model.Action;
import model.ActionForward;

public class lectureJoinController implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("lectureJoinController안의 execute() 실행됨");
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		Part part =request.getPart("file");
		String fileName = getFilename(part);
		if(fileName!=null && !fileName.isEmpty()) {
			part.write(fileName);

		}
		
		Part part2 =request.getPart("file2");
		String fileName2 = getFilename(part2);
		if(fileName2!=null && !fileName2.isEmpty()) {
			part2.write(fileName2);

		}
		
		Part part3 =request.getPart("file3");
		String fileName3 = getFilename(part3);
		if(fileName3!=null && !fileName3.isEmpty()) {
			part3.write(fileName3);

		}
		
		//2.전달되는 파라미터 정보저장 ->Member 생성
		lecture lc = new lecture();
		lc.setLec_title(request.getParameter("lec_title"));
		lc.setLec_lecturer(request.getParameter("lec_lecturer"));
		lc.setLec_contenta(request.getParameter("lec_contenta"));
		lc.setLec_contentb(request.getParameter("lec_contentb"));
		lc.setLec_category(request.getParameter("CategoryDown"));
		lc.setLec_thum("/img/"+fileName);
		lc.setLec_sectiona("/img/"+fileName2);
		lc.setLec_sectionb("/img/"+fileName3);
		
		String category = request.getParameter("CategoryDown");
		System.out.println("카테고리 불러온 값 : " +category);
		
		cm cm = new cm();
		cm.setLec_id(lc.getLec_id());
		String[] url = request.getParameterValues("lec_url");
		String[] chtitle = request.getParameterValues("cm_chtitle");
		
		//3. DB객체처리
		lectureDAO lcdao = new lectureDAO();
		lcdao.insertlecture(lc, cm, url, chtitle);


		System.out.println("lectureJoinController : 전달받은 정보 lecture 객체 확인 :" + lc.toString());

		System.out.println("lectureJoinController : 디비작업처리완료");
		
		//4. 페이지이동 : 무조건 Controller로 이동
		System.out.println("lectureJoinController : 페이지이동");
		ActionForward forward = new ActionForward();
		forward.setPath("lectureListController.lc");
		forward.setRedirect(true);
		return forward;
	}
	
	public String getFilename(Part part) {
        String fileName = null;   
        String header = part.getHeader("content-disposition");
        System.out.println("Header => "+header);

        int start = header.indexOf("filename=");
        fileName = header.substring(start+10,header.length()-1);        
        System.out.println("파일명:"+fileName);        
        return fileName; 
	}
	
	public String getFilename2(Part part2) {
        String fileName2 = null;   
        String header = part2.getHeader("content-disposition");
        System.out.println("Header => "+header);

        int start = header.indexOf("filename=");
        fileName2 = header.substring(start+10,header.length()-1);        
        System.out.println("파일명:"+fileName2);        
        return fileName2; 
	}
	
	public String getFilename3(Part part3) {
        String fileName3 = null;   
        String header = part3.getHeader("content-disposition");
        System.out.println("Header => "+header);

        int start = header.indexOf("filename=");
        fileName3 = header.substring(start+10,header.length()-1);        
        System.out.println("파일명:"+fileName3);        
        return fileName3; 
	}
	
	//다중 파일 처리
//	Collection<Part> parts = request.getParts();
//	StringBuilder builder = new StringBuilder();
//	
//	for(Part p : parts) {
//		if(!p.getName().equals("file")) continue;
//		
//		Part filePart = p;
//		String fileName = filePart.getSubmittedFileName();
//		builder.append(fileName);
//		builder.append(",");
//		
//		InputStream fis = filePart.getInputStream();
//		
//		String realPath = request.getServletContext().getRealPath("/upload");
//		System.out.println(realPath);
//		System.out.println(fileName);
//		
//		String filePath = realPath + File.separator +fileName;
//		FileOutputStream fos = new FileOutputStream(filePath);
//		
//		byte[] buf = new byte[1024];
//		int size = 0;
//		while((size=fis.read(buf)) != -1) {
//			fos.write(buf,0,size);
//		
//		}
//		fos.close();
//		fis.close();
//	}
}
