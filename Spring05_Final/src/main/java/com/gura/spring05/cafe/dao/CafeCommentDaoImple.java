package com.gura.spring05.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.cafe.dto.CafeCommentDto;

@Repository
public class CafeCommentDaoImple implements CafeCommentDao{
	@Autowired
	private SqlSession session;
	
	//인자로 전달된 그룹번호(원글의 글번호)에 해당하는 댓글 목록 얻어오기
	@Override
	public List<CafeCommentDao> getList(int ref_group) {
		return session.selectList("cafeComment.getList", ref_group);
	}

	@Override
	public void delete(int num) {
		//댓글 삭제해도 oracle table에서는 지우지 않고 deleted 칼럼에 "no"라고만 표시한다.
		//(해당 댓글이 DB에서도 삭제되면 대댓글의 경우 위치가 위로 당겨지기때문에 보기 좋지 않음)
		session.update("cafeComment.delete", num); 

	}
	
	@Override
	public void insert(CafeCommentDto dto) {
		session.insert("cafeComment.insert", dto);
		
	}
	
	//댓글의 시퀀스 값 얻기
	//대댓글의 그룹번호를 댓글의 그룹번호로 한다. 따라서 먼저 댓글의 시퀀스 값을 얻어내서 ㅕㅔ
	@Override
	public int getSequence() {
		int seq=session.selectOne("cafeComment.getSequence");
		return seq;
	}

	@Override
	public void update(CafeCommentDto dto) {
		session.update("cafeComment.update", dto);
		
	}
	
	
}
