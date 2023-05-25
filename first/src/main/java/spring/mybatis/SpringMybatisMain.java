package spring.mybatis;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMybatisMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/mybatis/spring-mybatis.xml");
		
		MemberService service = 
				factory.getBean("memberServiceimpl", MemberService.class);
		
		//전체리스트
		List<MemberDTO> list = service.memberList();
		for(MemberDTO dto : list) {
			System.out.println(dto.getMemberid() + ":" + dto.getName() + ":" + dto.getRegtime());
		}

	}

}
