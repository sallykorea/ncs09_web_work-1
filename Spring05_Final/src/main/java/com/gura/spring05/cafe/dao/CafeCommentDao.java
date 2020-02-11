package com.gura.spring05.cafe.dao;

import java.util.List;

import com.gura.spring05.cafe.dto.CafeCommentDto;
import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeCommentDao {
	public List<CafeCommentDto> getList(CafeDto dto);
	public void delete(int num);
	public void insert(CafeCommentDto dto);
	public int getSequence();
	public void update(CafeCommentDto dto);
	public int getCount();
}
