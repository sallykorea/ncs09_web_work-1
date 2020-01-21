package test.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/el03")
public class El03Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//세션 영역에 String type 담기
		//jsp에서는 session 객체가 기본으로 제공되지만 servlet에서는 제공되지 않는다. 따라서 request 객체를 통해 session 객체를 생성해 주어야한다.
		HttpSession session=req.getSession(); 
		session.setAttribute("myNick", "호빵맨");
		//jsp 페이지로 리다이렉트 이동하기
		String cPath=req.getContextPath();
		resp.sendRedirect(cPath+"/el/test03.jsp");
	}
}
