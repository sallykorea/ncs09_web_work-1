package test.fillter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/shop/*")
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		if(id != null) {
			chain.doFilter(request, resp);
		}else {
			String url=request.getRequestURI();
			String query=request.getQueryString();
			String encodedUrl=null;
			if(query==null) {
				encodedUrl=URLEncoder.encode(url);
			}else {
				encodedUrl=URLEncoder.encode(url+"?"+query);
			}
			System.out.println(url);
			System.out.println(query);
			System.out.println(encodedUrl);
			HttpServletResponse response=(HttpServletResponse)resp;
			String cPath=request.getContextPath();
			//로그인 폼으로 리다일렉트 시켜준다.
			response.sendRedirect(cPath+"/users/loginform.jsp?url="+encodedUrl);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
