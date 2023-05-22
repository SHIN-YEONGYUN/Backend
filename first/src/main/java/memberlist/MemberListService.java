package memberlist;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberlistservice")
//@Configuration
public class MemberListService {
	@Autowired
	MemberDAO dao;
	
	//@Bean
	ArrayList<MemberDTO> getList(int page, int cnt){
		if(page !=0 && cnt !=0) {
			return dao.getPagingMember(page, cnt);
		}
		else {
			return dao.getNonPagingMember();
		}
		
	}
}
//main
//ApplicationContext factory =
//new AnnotationConfigApplicationContext(MemberListService.class);


