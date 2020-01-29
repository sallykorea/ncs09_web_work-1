package com.gura.spring03.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {
	@RequestMapping("/users/loginform")
	public String loginform() {
		//수행할 비즈니스 로직이 없다
		//view page만 리턴해준다.
		return "users/loginform";
	}
	
}
