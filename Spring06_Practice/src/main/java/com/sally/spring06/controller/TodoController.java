package com.sally.spring06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sally.spring06.todo.dao.TodoDao;
import com.sally.spring06.todo.dto.TodoDto;

@Controller
public class TodoController {
	
	@Autowired
	private TodoDao dao;
	
	@RequestMapping("/todo/list")
	public ModelAndView list(ModelAndView mView) {
		List<TodoDto> list=dao.getList();
		mView.addObject("list", list);
		mView.setViewName("todo/list");
		return mView;
	}
}
