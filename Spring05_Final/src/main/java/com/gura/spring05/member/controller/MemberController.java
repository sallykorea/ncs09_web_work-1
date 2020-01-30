package com.gura.spring05.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.member.dao.MemberDao;
import com.gura.spring05.member.dto.MemberDto;

@Controller
public class MemberController {
	//의존 객체 주입 받기 (DI)
	@Autowired
	private MemberDao dao;
	
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		List<MemberDto> list=dao.getList();
		mView.addObject("list", list);
		mView.setViewName("member/list"); // WEB-INF/views/member/list.jsp 로 보낸다.
		return mView;
	}
	
	@RequestMapping("/member/delete")
	public String delete(@RequestParam int num) {
		dao.delete(num);
		return "redirect:/member/list.do";
	}
}
