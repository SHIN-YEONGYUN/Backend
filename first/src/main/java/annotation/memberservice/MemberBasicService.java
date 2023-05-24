package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service ("basicservice") 
//@Component 여도 되지만 의미적 구분
public class MemberBasicService implements MemberService {
	@Autowired
	MemberDAO dao ;

	//public void setDao(MemberDAO dao) {
	//	this.dao = dao;
	//}
	
	MemberBasicService(){
		System.out.println("MemberBasicService 객체생성");
	}
	@Override
	public void registerMember() {
		boolean result = dao.selectMember();
		if(!result) {
			dao.insertMember();
		}
	}

}


