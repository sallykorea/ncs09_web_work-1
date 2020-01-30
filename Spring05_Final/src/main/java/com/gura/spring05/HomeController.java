package com.gura.spring05;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
		return "home";
	}
	
}
