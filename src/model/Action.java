package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Action {
		//상수, 추상메서드 사용가능
		//1. 추상 메서드 작성
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
