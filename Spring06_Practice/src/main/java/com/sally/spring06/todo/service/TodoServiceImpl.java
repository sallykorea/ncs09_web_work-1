package com.sally.spring06.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.sally.spring06.todo.dao.TodoDao;
import com.sally.spring06.todo.dto.TodoDto;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodoDao dao;
	
	@Override
	public void getList(ModelAndView mView) {
		List<TodoDto> list=dao.getList();
		mView.addObject("list", list);
	}

	@Override
	public void delete(int num) {
		dao.delete(num);
	}

	@Override
	public void insert(String todo) {
		dao.insert(todo);
		
	}

	@Override
	public void getData(int num, ModelAndView mView) {
		TodoDto dto=dao.getData(num);
		mView.addObject("dto", dto);
		
	}

	@Override
	public void update(TodoDto dto) {
		dao.update(dto);
	}
	
	

}
