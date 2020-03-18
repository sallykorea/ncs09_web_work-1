package com.gura.spring05.member.dao;

import java.util.List;
import java.util.Map;

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
		List<MemberDto> list=session.selectList("member.getList"); //selectList() : data의 전체 row를 갖고 올 때 사용
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

	@Override
	public MemberDto getData(int num) {
		MemberDto dto=session.selectOne("member.getData", num); //selectOne() : 하나의 data를 갖고 올 때 사용
		return dto;
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
		
	}
	
	@Override
	public List<Map<String, Object>> getList2() {
		List<Map<String, Object>> list=session.selectList("member.getList2");
		return list;
	}

	@Override
	public List<Map<String, Object>> memberGetList() {
		return session.selectList("member.memberGetList");
	}

}
