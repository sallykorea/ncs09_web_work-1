package test.servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.CafeListController;

// .nhn 으로 끝나는 모든 요청을 처리할 서블릿 정의하기
@WebServlet("*.nhn")
public class GateServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 url을 조사한다
		String uri=request.getRequestURI();
		//컨텍스트 경로의 길이
		String cPath=request.getContextPath();
		int cLength=cPath.length();
		// 순수 요청 경로(컨텍스트 경로 제외, .nhn 제외)
		int index=uri.indexOf(".");
		
		// context path를 제외하고 순수 요청 경로만 알아내기(cLength이상 index미만 까지 갖고 오기)
		String path=uri.substring(cLength, index);
		
		if(path.equals("/cafe/list")) {
			new CafeListController().execute(request, response);
			
		}else if(path.equals("/cafe/insertform")) {
			
		}
	}
}
