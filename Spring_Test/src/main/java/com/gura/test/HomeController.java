package com.gura.test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/home.nhn")
	public String home(HttpServletRequest request) {
		List<String> notice=new ArrayList<String>();
		notice.add("1");
		notice.add("2");
		notice.add("3");
		
		request.setAttribute("notice", notice);
		
		return "home";
	}
	
}
