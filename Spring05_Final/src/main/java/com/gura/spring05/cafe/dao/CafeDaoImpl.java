package com.gura.spring05.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.cafe.dto.CafeDto;
import com.gura.spring05.users.dto.UsersDto;

@Repository
public class CafeDaoImpl implements CafeDao{
	@Autowired
	private SqlSession session;

	@Override
	public int getCount(CafeDto dto) {
		int count=session.selectOne("cafe.getCount", dto);
		return count; //리턴한다.
	}

	@Override
	public List<CafeDto> getList(CafeDto dto) {
		List<CafeDto> list=session.selectList("cafe.getList", dto);
		return list;
	}

	@Override
	public int insert(CafeDto dto) {
		int isSuccess=session.insert("cafe.insert", dto);
		return isSuccess;
	}
	
	@Override
	public CafeDto getData(int num) {
		CafeDto dto=session.selectOne("cafe.getData", num);
		return dto;
	}

	@Override
	public void addViewCount(int num) {
		session.update("cafe.addViewCount", num);
		
	}
}
