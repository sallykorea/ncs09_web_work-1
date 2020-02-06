package com.gura.spring05.cafe.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dao.CafeDao;
import com.gura.spring05.cafe.dto.CafeDto;

@Service
public class CafeServiceImpl implements CafeService{
	@Autowired
	private CafeDao dao;

	@Override
	public void list(HttpServletRequest request) {
		CafeDto dto=new CafeDto();
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
	public void showdetail(int num, ModelAndView mView) {
		//2. DB 에서 해당 글 정보를 얻어온다.
		CafeDto dto=dao.getData(num);
		//3. 해당글의 조회수를 1 증가 시킨다.
		dao.addViewCount(num);
		//4. 글 정보를 응답한다.
		mView.addObject("dto", dto);
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
}
