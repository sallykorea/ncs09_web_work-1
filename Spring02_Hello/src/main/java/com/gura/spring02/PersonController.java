package com.gura.spring02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
	@RequestMapping("/person.do")
	public String person(HttpServletRequest request) {
		request.setAttribute("person", "김남주");
		
		return "person";
	}
}
