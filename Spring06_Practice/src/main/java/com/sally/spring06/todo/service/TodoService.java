package com.sally.spring06.todo.service;

import org.springframework.web.servlet.ModelAndView;

import com.sally.spring06.todo.dto.TodoDto;

public interface TodoService {
	public void getList(ModelAndView mView);
	public void delete(int num);
	public void insert(String todo);
	public void getData(int num, ModelAndView mView);
	public void update(TodoDto dto);
}
