package test.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // Aspect 역할을 할 수 있도록
@Component // bean 이 될 수 있도록
public class PenAspect {
	
	/*
	 *  spring 이 관리 하는 객체의 메소드 중에서
	 *  리턴 type 은 void, 메소드 명은 write로 시작, 전달되는 인자가 없는
	 *  메소드 수행 이전(@Before)에 할 작업
	 */
	@Before("execution(void write*())") //@Before("어떤 곳에 적용할지 명시")
	public void prepare() {
		System.out.println("Pen을 준비해요!");
	}
	
	@After("execution(void write*())")
	public void after() {
		System.out.println("Pen을 마무리해요!");
	}
	
}
