package com.sally.spring07.lunch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sally.spring07.lunch.dao.LunchDao;
import com.sally.spring07.lunch.dto.LunchDto;

@Controller
public class LunchController {
	
	@Autowired
	private LunchDao dao;
	
	@RequestMapping("/lunch/list")
	public ModelAndView getList(ModelAndView mView) {
		List<LunchDto> list=dao.getList();
		mView.addObject("list", list);
		mView.setViewName("lunch/list");
		return mView;
	}
	
	@RequestMapping("/lunch/insertForm")
	public String insertForm() {
		return "lunch/insertForm";
	}
	
	@RequestMapping("/lunch/insert")
	public ModelAndView insert(@ModelAttribute("menu") String menu, ModelAndView mView) {
		boolean isSuccess=dao.insert(menu);
		mView.addObject("isSuccess", isSuccess);
		mView.setViewName("lunch/insert");
		return mView;
	}
	
}
