package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessengerAspect {
	/*
	 * 1. 리턴 type은 상관없다.(*  *)
	 * 2. 메소드 명이 send로 시작하는 메소드(send)
	 * 3. 메소드에 전달되는 인자도 상관없다.(..)-전달되는 메소드 인자 상관 없음 / (*)-메소드 인자 한개 /(*,*,*)-메소드 인자 세개 /(java.lang.String, *)-첫번째 인자의 type은 String type, 두번째 인자는 아무거나
	 * 
	 * 위의 3가지 조건을 모두 만족시 메소드에 아래의 aop가 적용된다.
	 */
	// joinPoint 참고 블로그 : http://closer27.github.io/backend/2017/08/03/spring-aop/
	// joinPoint는 메소드가 적용된 바로 그 지점, @Around에만 joinPoint가 있다.
	@Around("execution(* send*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		//aop가 적용된 메소드 수행 직전
		System.out.println("---수행이전---");
		
		//aop가 적용된 메소드에 전달된 인자를 Object[] 로 얻어 낼 수 있다.
		Object[] args=joinPoint.getArgs();
		//반복문 돌면서 찾고 싶은 type을 찾는다.
		for(Object tmp:args) {
			if(tmp instanceof String) {//만일 string type 이라면 (메소드에 전달되는 인자의 type의 알아내기위해 'instanceof' 연산자로 인자의 원래 type을 알아낼 수 있다.)
				//원래 type으로 casting
				String msg=(String)tmp;
				System.out.println("aop 에서 읽어낸 내용 : "+msg);
				//특정 메소드를 수행하지 않도록 하기
				if(msg.contains("바보")) {
					System.out.println("바보라고 하기 없기!");
					return; //메소드를 여기서 종료 시킨다. proceed() 호출하지 않도록
				}
			}
		}
		//aop가 적용된 클래스(Messenger Class)와 위의 코드를 합쳐서 새로운 클래스를 만든다. 그리고 그 클래스의 메소드를 사용하는 것이다.
		
		//aop가 적용된 메소드 수행하고 리턴되는 값 받아오기(void 면 null 이다.)
		// proceed()를 사용해야 aop를 적용한 클래스가 수행된다.
		Object obj=joinPoint.proceed();
	
		//aop가 적용된 메소드 리턴 직후
		System.out.println("---수행직후---");
	}
}
