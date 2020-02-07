package com.gura.spring05.cafe.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String  showContent(HttpServletRequest request) {
		service.showdetail(request);
		return "cafe/detail";
	}
	
	@RequestMapping("/cafe/updateform")
	public ModelAndView authUpdateForm(HttpServletRequest request, @RequestParam int num, ModelAndView mView) {
		service.updateDtailForm(num, mView);
		mView.setViewName("cafe/updateform");
		return mView; 
		// new ModelAndView()로 새로운 객체를 생성해서 return 하면 스프링은 최종적으로 리턴된 값을 읽어간다. 따라서 CafeServiceImpl의  mView에 담은 dto는 읽히지 않는다.
	}
	
	@RequestMapping(value = "/cafe/update")
	public ModelAndView authUpdate(HttpServletRequest request, @ModelAttribute("dto") CafeDto dto, ModelAndView mView) {
		service.updateDtail(request, dto);
		mView.setViewName("cafe/update");
		return mView;
	}
	
	@RequestMapping("/cafe/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		service.delete(request, response);
		return new ModelAndView("cafe/delete");
	}
	
	//댓글 저장 요청 처리
	@RequestMapping(value = "/cafe/comment_insert", method = RequestMethod.POST)
	public ModelAndView authCommentInsert(HttpServletRequest request, @RequestParam int ref_group) {
		service.saveComment(request);
		return new ModelAndView("redirect:/cafe/detail.do?num="+ref_group);
	}
}
