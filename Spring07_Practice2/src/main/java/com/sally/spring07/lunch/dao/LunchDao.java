package com.sally.spring07.lunch.dao;

import java.util.List;

import com.sally.spring07.lunch.dto.LunchDto;

public interface LunchDao {
	public List<LunchDto> getList();
	public boolean insert(String menu);
}
