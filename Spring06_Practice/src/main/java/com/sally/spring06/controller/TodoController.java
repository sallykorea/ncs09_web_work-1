package com.sally.spring06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sally.spring06.todo.dao.TodoDao;
import com.sally.spring06.todo.dto.TodoDto;
import com.sally.spring06.todo.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	@RequestMapping("/todo/list")
	public ModelAndView list(ModelAndView mView) {
		service.getList(mView);
		mView.setViewName("todo/list");
		return mView;
	}
	
	@RequestMapping("/todo/delete")
	public String delete(@RequestParam int num) {
		service.delete(num);
		return "redirect:/todo/list.hello";
	}
	
	@RequestMapping("/todo/insertform")
	public String insertform() {
		return "todo/insertform";
	}
	
	@RequestMapping("/todo/insert")
	public ModelAndView insert(@ModelAttribute("todo") String todo, ModelAndView mView ) {
		service.insert(todo);
		mView.setViewName("todo/insert");
		return mView;
	}
	
	@RequestMapping("/todo/updateform")
	public ModelAndView updateform(@RequestParam int num, ModelAndView mView) {
		service.getData(num, mView);
		mView.setViewName("todo/updateform");
		return mView;
	}
	
	@RequestMapping("/todo/update")
	public ModelAndView update(@ModelAttribute("dto") TodoDto dto, ModelAndView mView) {
		service.update(dto);
		mView.setViewName("todo/update");
		return mView;
	}
	
}
