package com.gura.spring05.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gura.spring05.member.dao.MemberDao;
import com.gura.spring05.member.dto.MemberDto;

@Controller
public class AndroidController {
	
	@Autowired
	private MemberDao dao;
	
	/*
	 * ["김구라", "해골", "원숭이"] 형식의 문자열이 응답되는 메소드
	 */
	@ResponseBody
	@RequestMapping("/android/getnames")
	public List<String> getNames() {
		List<String> names=new ArrayList<String>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		return names;
	}
	/*
	 * {"num":1, "name":"김구라", "isMan":true}형식의 json 문자열이 응답된다.
	 */
	@ResponseBody
	@RequestMapping("/android/getDetail")
	public Map<String, Object> getDetail() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		return map;
	}
	/*
	 * [{},{},{},...]형식의 json 문자열이 응답된다.
	 */
	@ResponseBody  //@ResponseBody 가 있어야 jackson-databind 라이브러리에서 json 형식으로 변경해준다.
	@RequestMapping("/android/getList")
	public List<Map<String, Object>> getList(){
		List<Map<String, Object>> list=dao.getList2();
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/android/member/list")
	public List<Map<String, Object>> memberGetList() {
		List<Map<String, Object>> list=dao.memberGetList();
		return list;
	}
	/*
	 *  Dto 를 리턴하고 @ResponseBody 어노테이션을 붙여도
	 *  Map 을 리턴한 것과 동일하게 응답된다.
	 *  {"num":1, "name":"김구라", "addr":"노량진"}
	 */
	@ResponseBody
	@RequestMapping("/android/member/detail")
	public MemberDto memberDetail(@RequestParam int num) {
		return dao.getData(num);
	}
	
	@ResponseBody
	@RequestMapping("/android/member/delete")
	public String memberDelete(@RequestParam int num) {
		dao.delete(num);
		return "{\"isSuccess\":true}";
	}
	
	/*
	 * 요청되는 파라미터의 이름과 MemberDto의 필드명이 같은 경우,
	 * Spring 프레임워크가 자동으로 dto 객체에 담아준다.(get방식, post방식 모두 가능)
	 * (@ModelAttribute 어노테이션을 붙여줘도 되고 없어도 된다.) 
	 * 
	 * 예) 요청 파라미터가 name=김구라&addr=노량진 인 경우,
	 *		MemberDto dto=new MemberDto();
	 *		dto.setName(name);
	 *		dto.setAddr(addr);
	 *
	 *@ModelAttribute("dto")라고 작성을 하면 
	 */
	@ResponseBody
	@RequestMapping("/android/member/insert")
	public String memberDelete(@ModelAttribute MemberDto dto) {
		dao.insert(dto);
		return "{\"isSuccess\":true}";
	}

}
