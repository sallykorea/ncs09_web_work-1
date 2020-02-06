package com.gura.spring05.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dto.CafeDto;
import com.gura.spring05.cafe.service.CafeService;

@Controller
public class CafeController {
	@Autowired
	private CafeService service;
	
	@RequestMapping("/cafe/list")
	public ModelAndView list(ModelAndView mView, HttpServletRequest request) {
		service.list(request);
		mView.setViewName("cafe/list");
		return mView;
	}
	
	@RequestMapping("/cafe/insertform")
	public ModelAndView authUploadForm(HttpServletRequest request) {
		return new ModelAndView("cafe/insertform");
	}
	
	@RequestMapping(value = "/cafe/insert", method = RequestMethod.POST)
	public ModelAndView authUpload(HttpServletRequest request, @ModelAttribute("dto") CafeDto dto, ModelAndView mView) {
		service.saveContent(request, dto);
		mView.setViewName("cafe/insert");
		return mView;
	}
	
	@RequestMapping("/cafe/detail")
	public ModelAndView showContent(@RequestParam int num, ModelAndView mView) {
		service.showdetail(num, mView);
		mView.setViewName("cafe/detail");
		return mView;
	}
}
