package test.servelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fortune")
public class FortuneServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 오늘의 운세를 얻어오는 비즈니스 로직을 수행한다.(비즈니스 로직을 수행해서 얻어온 data를 'Model'이라고 한다.)
		String fortuneToday="사물함 근처로 가면 잠자는 반장님을 만날꺼예요";
		//2. 로직 수행결과 모델(data)를 request에 담는다.
		req.setAttribute("fortuneToday", fortuneToday);
		//3. view page (jsp 페이지)로 forward 이동해서 응답한다.
		RequestDispatcher rd=req.getRequestDispatcher("/views/fortune.jsp");
		rd.forward(req, resp);
	}
}
