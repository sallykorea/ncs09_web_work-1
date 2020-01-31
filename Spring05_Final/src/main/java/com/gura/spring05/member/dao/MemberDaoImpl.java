package com.gura.spring05.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.member.dto.MemberDto;

@Repository  //MemberDaoImpl를 bean으로 생성하기 위해 어노테이션을 붙여준다.
public class MemberDaoImpl implements MemberDao{
	
	@Autowired  //핵심 의존 객체를 spring bean container로 부터 주입 받기 (DI : Dependency Injection)
	private SqlSession session;
	
	@Override
	public List<MemberDto> getList() {
		List<MemberDto> list=session.selectList("member.getList");
		
		return list;
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete", num);
		
	}

	@Override
	public void insert(MemberDto dto) {
		session.insert("member.insert", dto);
		
	}

}
