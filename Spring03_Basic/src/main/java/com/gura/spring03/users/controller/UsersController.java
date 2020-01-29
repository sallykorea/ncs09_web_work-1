package com.gura.spring03.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
	@RequestMapping("/users/loginform")
	public String loginform() {
		//수행할 비즈니스 로직이 없다
		//view page만 리턴해준다.
		return "users/loginform";
	}
	
	@RequestMapping("/users/login")
	public String login(HttpServletRequest request, HttpSession session) {
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		boolean isSuccess=false;
		if(id.equals("gura")&&pwd.equals("1234")) {
			isSuccess=true;
			session.setAttribute("id", id);
		}
		
		request.setAttribute("isSuccess", isSuccess);
		
		return "users/login";
	}
	
	/*
	 * @RequestParam 어노테이션은 전송되는 파라미터를 자동으로 추출할때 사용한다.
	 * 단, 지역 변수의 이름은 파라미터의 이름과 같아야한다.
	 */
	@RequestMapping("/users/login2")
	public ModelAndView login2(@RequestParam String id, @RequestParam String pwd, HttpSession session, ModelAndView mView) {
		//유효한 정보인지 여부
		boolean isSuccess=false;
		if(id.equals("gura")&&pwd.equals("1234")) {
			isSuccess=true;
			session.setAttribute("id", id);
		}
		
		mView.addObject("isSuccess", isSuccess);
		mView.setViewName("users/login");
		
		return mView;
	}
}
