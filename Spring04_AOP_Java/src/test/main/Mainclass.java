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
		
		ApplicationContext context=new ClassPathXmlApplicationContext("test/main/init.xml");
		WritingUtil util2=context.getBean(WritingUtil.class);
		util2.write1();
		util2.write2();
		util2.write3();
	}
}
