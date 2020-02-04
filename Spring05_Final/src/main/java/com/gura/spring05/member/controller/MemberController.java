package com.gura.spring05.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.member.dao.MemberDao;
import com.gura.spring05.member.dto.MemberDto;
import com.gura.spring05.member.service.MemberService;
/*
 * Controller의 역할
 * 어떤 service를 이용해서 비즈니스 로직을 처리하고
 * 어떤 응답페이지로 보낼지 결정한다.
 * 클라이언트가 요청시 파라미터를 함께 보내면 그 파라미터를 받아서 전달하는 역할도 한다.
 */
@Controller
public class MemberController {
	//의존 객체 주입 받기 (DI)
	//@Autowired
	//private MemberDao dao;  //MemberDaoImpl type으로 객체의 참조값을 갖고 오면 메소드들의 설명서(?)를 MemberDaoImpl 것으로 갖고 오게 된다. 
							//따라서 MemberDaoImpl을 import 해야하고 그러면 의존관계를 느슨하게 할 수 없게 된다.(스프링의 사용 이유가 사라짐)
							//위와 같은 이유때문에 interface를 사용해서 메소드를 구현하고, interface type으로 dao 객체의 참조값을 받아오는 것이다. 
	@Autowired
	private MemberService service;
	
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		service.getList(mView);
		mView.setViewName("member/list");
		return mView;
	}
	
	@RequestMapping("/member/delete")
	public String delete(@RequestParam int num) {
		service.deleteMember(num);
		return "redirect:/member/list.do";
	}
	
	@RequestMapping("/member/insertform")
	public String insertform() {
		//수행할 비즈니스 로직 없음
		return "member/insertform";
	}
	/*
	 * @ModelAttribute MemberDto dto 를 메소드의 인자로 선언하면
	 * 폼 전송되는 파라미터가 자동으로 MemberDto 객체에 setter 메소드를 통해서 들어가고 
	 * 그 객체가 메소드의 인자로 전달된다.
	 * 단, 파라미터명과 Dto 의 필드명이 일치해야된다.
	 * 
	 * @ModelAttribute("dto") MemberDto dto
	 * ("key 명 작성") 하면 작성한 key 명으로 request 객체에 자동으로 인자에 전달된 값을 담아준다.
	 * 1. 전송되는 파라미터를 자동으로 추출해서 MemberDto에 담아 주기도 하고
	 * 2. "dto" 라는 키값으로 MemberDto 객체를 request 영역에 담아는 역할도 한다.
	 * 
	 */	
	@RequestMapping("/member/insert")
	public ModelAndView insert(@ModelAttribute("dto") MemberDto dto, ModelAndView mView) { 
		service.insert(dto);
		//mView.addObject("dto", dto);
		mView.setViewName("member/insert");
		return mView;
	}
	
	@RequestMapping("/member/updateform")
	public ModelAndView updateform(@RequestParam int num, ModelAndView mView) {
		service.getMember(mView, num);
		mView.setViewName("member/updateform");
		return mView;
	}
	
	@RequestMapping("/member/update")
	public ModelAndView update(@ModelAttribute("dto") MemberDto dto, ModelAndView mView) {
		service.updateMember(dto);
		mView.setViewName("member/update");
		return mView;
	}
	

}
