package memberlist;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "memberlist")
public class MmberListMain {

	public static void main(String[] args) {
		//xml 설정 없이 자바 annotation 만 사용
		//MembeRsERVICE . getList (1,5) 
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(MmberListMain.class);
		ArrayList<MemberDTO> list = 
				context.getBean("memberlistservice", MemberListService.class)
				.getList(1,5);
		for(MemberDTO dto : list) {
			System.out.println(dto.getMemberid()+":" + dto.getName());
		}
		
	}

}
