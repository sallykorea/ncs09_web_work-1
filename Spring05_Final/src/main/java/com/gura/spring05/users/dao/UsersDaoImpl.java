package com.gura.spring05.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDaoImpl implements UsersDao{

	@Autowired
	private SqlSession session;

	@Override
	public boolean isExist(String inputId) {
		//인자로 전달되는 아이디를 이용해서 select 를 한다.
		String id=session.selectOne("users.isExist", inputId);
		//만일 select 된 결과가 null 이면 존재하지 않는 아이디이다.
		if(id==null) {
			return false;
		}else {
			return true;
		}
	}

}
