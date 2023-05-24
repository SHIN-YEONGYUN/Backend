package aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aop2/aop.xml");
		Board board = factory.getBean("board", Board.class); 
		System.out.println("==================================");
		board.getList(); //Common.a() 먼저 실행 + ....
		System.out.println("==================================");
		System.out.println("==================================");
		board.insert(6); //Common.a() 먼저 실행 + ....
		System.out.println("==================================");
		
		Member member = factory.getBean("member", Member.class);
		System.out.println("==================================");
		member.login("aop");
		System.out.println("==================================");
		System.out.println("==================================");
		member.logout();//Common.a() 먼저 실행 + ....
		System.out.println("==================================");
	}

}
