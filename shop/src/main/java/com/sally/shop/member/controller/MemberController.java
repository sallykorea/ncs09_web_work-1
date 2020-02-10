package com.sally.shop.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value = "/member/signupform")
	public String loginForm() {
		return "member/signupform";
	}
	
	@RequestMapping(value = "/member/checkid", method = RequestMethod.GET)
	public Map<String, Object> checkId(String inputId){
		service.isExistId(inputId);
	}
	
}
