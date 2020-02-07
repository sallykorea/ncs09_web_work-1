package com.gura.spring05.cafe.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dao.CafeCommentDao;
import com.gura.spring05.cafe.dao.CafeDao;
import com.gura.spring05.cafe.dto.CafeCommentDto;
import com.gura.spring05.cafe.dto.CafeDto;

@Service
public class CafeServiceImpl implements CafeService{
	@Autowired
	private CafeDao dao;
	@Autowired
	private CafeCommentDao cafeCommentDao;

	@Override
	public void list(HttpServletRequest request) {
		/*
		 *  request 에 검색 keyword 가 전달될수도 있고 안될수도 있다.
		 *  - 전달 안되는 경우 : navbar 에서 cafe를 누른경우 
		 *  - 전달 되는 경우 : 하단에 검색어를 입력하고 검색 버튼을 누른경우
		 *  - 전달 되는 경우2: 이미 검색을 한 상태에서 하단 페이지 번호를 누른 경우 
		 */
		//검색과 관련된 파라미터를 읽어와 본다.
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		
		CafeDto dto=new CafeDto();
		if(keyword!=null) {
			if(condition.equals("titlename")) {//제목+글내용
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if (condition.equals("title")) {//제목 검색
				dto.setTitle(keyword);
			}else if (condition.equals("writer")) {//작성자 검색
				dto.setWriter(keyword);
			}
			
			/*
			 *  검색 키워드에는 한글이 포함될 가능성이 있기 때문에
			 *  링크에 그대로 출력가능하도록 하기 위해 미리 인코딩을 해서
			 *  request 에 담아준다.
			 */
			String encodedKeyword=null;
			try {
				encodedKeyword=URLEncoder.encode(keyword, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			//키워드와 검색조건을 request 에 담는다. 
			request.setAttribute("keyword", keyword);
			request.setAttribute("encodedKeyword", encodedKeyword);
			request.setAttribute("condition", condition);
		}
		
		//한 페이지에 나타낼 row 의 갯수
		final int PAGE_ROW_COUNT=5;
		//하단 디스플레이 페이지 갯수
		final int PAGE_DISPLAY_COUNT=5;
		
		//보여줄 페이지의 번호
		int pageNum=1;
		//보여줄 페이지의 번호가 파라미터로 전달되는지 읽어와 본다.	
		String strPageNum=request.getParameter("pageNum");
		if(strPageNum != null){//페이지 번호가 파라미터로 넘어온다면
			//페이지 번호를 설정한다.
			pageNum=Integer.parseInt(strPageNum);
		}
		//보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		
		//전체 row 의 갯수를 읽어온다.
		int totalRow=dao.getCount(dto);
		//전체 페이지의 갯수 구하기
		int totalPageCount=
				(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//시작 페이지 번호
		int startPageNum=
			1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		//끝 페이지 번호가 잘못된 값이라면 
		if(totalPageCount < endPageNum){
			endPageNum=totalPageCount; //보정해준다. 
		}		
		// CafeDto 객체에 위에서 계산된 startRowNum 과 endRowNum 을 담는다.
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		
		//1. DB 에서 글 목록을 얻어온다.
		List<CafeDto> list=dao.getList(dto);
		//2. 글 목록을 응답한다.
		
		//EL, JSTL 을 활용하기 위해 필요한 모델을 request 에 담는다.
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("totalPageCount", totalPageCount);
		request.setAttribute("totalRow", totalRow);
		
	}

	@Override
	public void saveContent(HttpServletRequest request, CafeDto dto) {
		//1. 폼 전송되는 파라미터 읽어오기 (글제목, 내용)
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		//글 작성자
		String writer=(String)request.getSession().getAttribute("id");
		//CafeDto 객체에 작성자, 제목, 내용을 담고 
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		//2. DB 에 글 정보를 저장하고
		int isSuccess=dao.insert(dto);
		//3. 응답하기 
		if(isSuccess>0) {
			request.setAttribute("isSuccess", true);
		}else {
			request.setAttribute("isSuccess", false);
		}
		
	}

	@Override
	public void showdetail(HttpServletRequest request) {
		//파라미터로 전달되는 글번호
		int num=Integer.parseInt(request.getParameter("num"));
		
		//검색과 관련된 파라미터를 읽어와 본다.
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		
		//CafeDto 객체 생성 (select 할때 필요한 정보를 담기 위해)
		CafeDto dto=new CafeDto();
		
		if(keyword != null) {//검색 키워드가 전달된 경우
			if(condition.equals("titlecontent")) {//제목+내용 검색
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")) {//제목 검색
				dto.setTitle(keyword);
			}else if(condition.equals("writer")) {//작성자 검색
				dto.setWriter(keyword);
			}
			//request 에 검색 조건과 키워드 담기
			request.setAttribute("condition", condition);
			/*
			 *  검색 키워드에는 한글이 포함될 가능성이 있기 때문에
			 *  링크에 그대로 출력가능하도록 하기 위해 미리 인코딩을 해서
			 *  request 에 담아준다.
			 */
			String encodedKeyword=null;
			try {
				encodedKeyword=URLEncoder.encode(keyword, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			//인코딩된 키워드와 인코딩 안된 키워드를 모두 담는다.
			request.setAttribute("encodedKeyword", encodedKeyword);
			request.setAttribute("keyword", keyword);
		}		
		//CafeDto 에 글번호도 담기
		dto.setNum(num);
		//조회수 1 증가 시키기
		dao.addViewCount(num);
		//글정보를 얻어와서
		CafeDto dto2=dao.getData(num);
		//request 에 글정보를 담고 
		request.setAttribute("dto", dto2);
		//댓글 목록을 얻어와서 request 에 담아준다.
		List<CafeCommentDto> commentList=cafeCommentDao.getList(num);
		request.setAttribute("commentList", commentList);
	}
	
	@Override
	public void updateDtailForm(int num, ModelAndView mView) {
		CafeDto dto=dao.getData(num);
		mView.addObject("dto", dto);
	}

	@Override
	public void updateDtail(HttpServletRequest request, CafeDto dto) {
		//1. 폼 전송되는 파라미터 읽어오기
		int num=Integer.parseInt(request.getParameter("num"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		//글 작성자
		String writer=(String)request.getSession().getAttribute("id");
		//CafeDto 객체에 작성자, 제목, 내용을 담고 
		dto.setNum(num);
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		//2. DB 에 글 정보를 저장하고
		int isSuccess=dao.update(dto);
		//3. 응답하기 
		if(isSuccess>0) {
			request.setAttribute("isSuccess", true);
		}else {
			request.setAttribute("isSuccess", false);
		}
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1. 삭제할 글번호를 읽어온다.
		int num=Integer.parseInt(request.getParameter("num"));
		
		//세션의 아이디와 글 작성자를 비교해서 같을때만 삭제한다. 
		String id=(String)request.getSession().getAttribute("id");
		//글작성자
		String writer=dao.getData(num).getWriter();
		//아이디와 글 작성자와 같은지 여부
		boolean isEqual=id.equals(writer);
		if(!isEqual){
			//에러를 응답하고 
			response.sendError(HttpServletResponse.SC_FORBIDDEN,
					"남의 글 삭제 하기 없기!");
			//메소드를 종료한다.
			return;
		}
		
		//2. DB 에서 삭제 한다.
		int isSuccess=dao.delete(num);
		//3. 응답하기 
		if(isSuccess>0) {
			request.setAttribute("isSuccess", true);
		}else {
			request.setAttribute("isSuccess", false);
		}
	}

	@Override
	public void saveComment(HttpServletRequest request) {
		//댓글 작성자
		String writer=(String)request.getSession().getAttribute("id");
		//댓글의 그룹번호
		int ref_group=Integer.parseInt(request.getParameter("ref_group"));
		//댓글의 대상자 아이디
		String target_id=request.getParameter("target_id");
		//댓글의 내용
		String content=request.getParameter("content");
		//댓글 내에서의 그룹번호 (null 이면 원글의 댓글이다)
		String comment_group=request.getParameter("comment_group");		
		//저장할 댓글의 primary key 값이 필요하다
		int seq = cafeCommentDao.getSequence();
		//댓글 정보를 Dto 에 담기
		CafeCommentDto dto=new CafeCommentDto();
		dto.setNum(seq);
		dto.setWriter(writer);
		dto.setTarget_id(target_id);
		dto.setContent(content);
		dto.setRef_group(ref_group);
		
		if(comment_group==null) {//원글의 댓글인 경우
			//댓글의 글번호가 댓글의 그룹 번호가 된다.
			dto.setComment_group(seq);
		}else {//댓글의 댓글인 경우
			//comment_group 번호가 댓글의 그룹번호가 된다.
			dto.setComment_group(Integer.parseInt(comment_group));
		}
		
		//댓글 정보를 DB 에 저장한다.
		cafeCommentDao.insert(dto);
		
	}
}
