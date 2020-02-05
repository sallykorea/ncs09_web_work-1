package com.gura.spring05.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
/*
 * Exception이 발생했을대 처리하는 컨트롤러 만들기
 * - @ControllerAdvice 어노테이션을 클래스에 붙인다.
 * - 메소드에 @ExceptionHandler(예외 class type) 을 붙여서 예외를 처리한다.
 */
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class ExceptionController {
	
	@ResponseStatus(HttpStatus.FORBIDDEN) // response 상태값을 추가하면 응답과 에러메시지도 함께 나온다.(검사-NetWork-status)
	@ExceptionHandler(CanNotDeleteException.class) // 이 어노테이션만 있으면 정상 응답한 페이지라고 나온다. (200에러)
	public ModelAndView canNotDelete() {
		ModelAndView mView=new ModelAndView();
		mView.addObject("msg","남의 파일을 지우면 안된다.");
		mView.setViewName("error/forbidden");
		return mView;
	}
}
