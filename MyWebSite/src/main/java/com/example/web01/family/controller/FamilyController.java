package com.example.web01.family.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.web01.family.dao.FamilyDao;
import com.example.web01.family.dto.FamilyDto;

@Controller
public class FamilyController {
	
	@Autowired
	private FamilyDao dao;
	
	@RequestMapping("/family/list")
	public ModelAndView getList(ModelAndView mView) {
		List<FamilyDto> list=dao.getList();
		mView.addObject("list", list);
		mView.setViewName("family/list");
		return mView;
	}
	
	@RequestMapping("/family/insertForm")
	public String insertForm() {
		return "family/insertForm";
	}
	
	@RequestMapping("/family/insert")
	public ModelAndView insert(@ModelAttribute("dto") FamilyDto dto, ModelAndView mView) {
		dao.insert(dto);
		mView.setViewName("family/insert");
		return mView;
	}
	
	@RequestMapping("/family/delete")
	public String delete(@RequestParam int num) {
		dao.delete(num);
		return "redirect:/family/list.do";
	}
	
	@RequestMapping("/family/updateForm")
	public ModelAndView updateform(@RequestParam int num, ModelAndView mView) {
		FamilyDto dto=dao.getData(num);
		mView.addObject("dto", dto);
		mView.setViewName("family/updateForm");
		return mView;
	}
	
	@RequestMapping("/family/update")
	public ModelAndView update(@ModelAttribute("dto") FamilyDto dto, ModelAndView mView) {
		dao.update(dto);
		mView.setViewName("family/update");
		return mView;
	}

}
