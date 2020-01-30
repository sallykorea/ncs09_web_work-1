package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.WritingUtil;

public class Mainclass {
	public static void main(String[] args) {
		WritingUtil util=new WritingUtil();
		util.write1();
		util.write2();
		util.write3();
		
		System.out.println("---------");
		
		
		//메인메소드가 실행 되는 시점에 객체가 생성되고, 메인 메소드가 종료되면 객체는 사라진다. 
		//스프링에서는 서버가 종료되기 전까지 객체가 생성되되고, 스프링에 의해 계속해서 객체가 관리된다.
		ApplicationContext context=new ClassPathXmlApplicationContext("test/main/init.xml");//어디에 있는 문서를 해석해서 객체를 만들지 지정하는 객체.
		WritingUtil util2=context.getBean(WritingUtil.class);//spring bean context로  부터 'WritingUtil.class'type을 찾아서 해당 객체의 참조값을 리턴해준다.
		util2.write1();
		util2.write2();
		util2.write3();
	}
}
