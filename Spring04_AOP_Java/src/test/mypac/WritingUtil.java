package test.mypac;

import org.springframework.stereotype.Component;
/*
 * [bean 이 된다.]
 * 
 * - 해당 클래스로 객체가 생성되고 스프링 bean 컨테이너에서 관리가 된다.
 * 
 */

//@Component 어노테이션을 부텨 놓으면 컴포넌트 스캔을 했을때 bean이 된다.
@Component
public class WritingUtil {
	public void write1() {
		System.out.println("편지를 써요");
	}
	
	public void write2() {
		System.out.println("일기를 써요");
	}
	
	public void write3() {
		System.out.println("소설을 써요");
	}
}
