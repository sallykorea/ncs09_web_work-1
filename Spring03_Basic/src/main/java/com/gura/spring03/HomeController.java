package com.gura.spring03;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 *  @Controller 어노테이션
 *  - 해당 클래스가 Spring MVC 프로젝트에서 Controller 가 될 수 있도록 한다.
 *  - component scan을 통해서 spring bean container 에서 관리가 되는 bean이 되어야 동작을 한다.
 */
@Controller
public class HomeController {
	
	// /home.do 요청이 왔을때 요청을 처리하게 하는 @RequestMapping 어노테이션
	@RequestMapping("/home.do")
	public String home(HttpServletRequest request) {
		
		//모델
		List<String> notice=new ArrayList<String>();
		notice.add("감기조심");
		notice.add("코루나 바이러스 조심");
		notice.add("손 잘씻기");
		notice.add("마스크 하기");
		
		//모델을 request 객체에 담는다.
		request.setAttribute("notice", notice);
		
		/*
		 *  "home" 을 리턴해주면
		 *	(servlet-context.xml 에 의해)	
		 *	 "/WEB-INF/views/"+"home"+".jsp" 와 같은 문자열이 만들어지고
		 *	
		 *	/WEB-INF/views/home.jsp 페이지로 forward 이동 되어서 응답된다.
		 *
		 */
		
		return "home";
	}
	
	@RequestMapping("/play")
	public ModelAndView	play(HttpSession session, ModelAndView mView) {
		String id=(String)session.getAttribute("id");
		if(id==null) {
			mView.setViewName("redirect:/users/loginform.do");
		}else {
			mView.setViewName("play");
		}
		
		return mView;
	}
	
}
