package member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {
/*1월 회원가입 1000포인트 부여 / 나머지달 포인트 없다 -- 서비스 클래스 공통 기능 통일 */ 
	public static void main(String[] args) {
		ApplicationContext factory = new
		ClassPathXmlApplicationContext("member/member.xml");		
		//MemberDTO dto = (MemberDTO)factory.getBean("dto2");
		MemberDAO dao = (MemberDAO)factory.getBean("dao");

		boolean result =dao.selectMember();
		if(result ==true) {
			System.out.println
			(dao.dto.getMemberid() + " 님 정상 로그인 사용자입니다.");
		}
		else {
			dao.insertMember();
		}
	}

}
