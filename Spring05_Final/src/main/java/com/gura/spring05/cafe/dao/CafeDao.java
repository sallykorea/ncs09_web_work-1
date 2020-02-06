package com.gura.spring05.cafe.dao;

import java.util.List;

import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeDao {
	public int getCount(CafeDto dto);
	public List<CafeDto> getList(CafeDto dto);
	public int insert(CafeDto dto);
	public CafeDto getData(int num);
	public void addViewCount(int num);
	public int update(CafeDto dto);
	public int delete(int num);
}
