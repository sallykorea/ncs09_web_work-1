package test.sercurity;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str=scan.nextLine();
		//문자열을 암호화해주는 객체 생성
		//security.xml 문서에 정의 되어 있는 객체이다.
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		//입력한 문자열을 암호화 한다.
		String result=encoder.encode(str);
		System.out.println("입력한 문자 : "+str);
		System.out.println("암호화된 문자 : "+result); //법칙없이 암호화된다. 암호화된 내용은 decoding 할 수 없다.
		
	}
}
