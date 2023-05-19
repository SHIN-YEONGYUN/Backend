package memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		ApplicationContext factory = new
		ClassPathXmlApplicationContext("memberservice/member.xml");		
		//memberdao-dto2, pointdao,
		Memberservice service = factory.getBean("service", Memberservice.class);
		service.registerMember();
	}

}
