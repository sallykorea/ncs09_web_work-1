package com.sally.spring07.lunch.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sally.spring07.lunch.dto.LunchDto;

@Repository
public class LunchDaoImpl implements LunchDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<LunchDto> getList() {
		List<LunchDto> list=session.selectList("lunch.getList");
		return list;
	}

	@Override
	public boolean insert(String menu) {
		boolean isSuccess=false;
		int addMenu=session.insert("lunch.insert", menu);
		if(addMenu>0) {
			isSuccess=true;
		}else {
			isSuccess=false;
		}
		
		return isSuccess;
	}
	
	
	
}
