package com.sally.spring06.todo.dao;

import java.util.List;

import com.sally.spring06.todo.dto.TodoDto;

public interface TodoDao {
	public List<TodoDto> getList();
	public void delete(int num);
	public void insert(String todo);
}
