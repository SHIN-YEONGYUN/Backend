package mybatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisMain2 {

	public static void main(String[] args) throws IOException {
		//SqlSession = jdbc Connection 
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build( Resources.getResourceAsReader("mybatis/mybatis-config.xml") );
		SqlSession session = factory.openSession(true); //auto commit 설정
	
		MemberDAO dao = new MemberDAO();
		dao.setSession(session);
		
		MemberService service = new MemberServiceimpl();
		((MemberServiceimpl)service).setDao(dao);
		
		/*List<MemberDTO> list = service.memberList();
		System.out.println("총회원수 = " + list.get(list.size()-1).getPw());
		for(int i = 0; i < list.size()-1; i++) {
			System.out.println(list.get(i));
		}*/
		/*
		MemberDTO dto = service.oneMember("jdbc2");
		System.out.println("나의정보 = " + dto);
		*/
		
		/*MemberDTO dto = new MemberDTO();
		dto.setMemberid("mybaits4");
		dto.setName("박진주");
		dto.setPw(3333);
		dto.setPhone("010-3333-3336");
		dto.setEmail("jin@ju.com");
		String result = service.registerMember(dto);
		System.out.println(result);
		*/
		
		/*
		 * 1.memberid 해당 회원정보 MemberDTO 리턴받는다 - dao.xxxx
		 * 2-1.리턴받는 정보가 있다 - 아이디 중복 - 회원 가입 불가능합니다.
		 * 2-2.리턴받는 정보 없다 - dao.xxxxx - 정상적으로 회원가입되었습니다.
		 * */
		
		/*MemberDTO dto = new MemberDTO();
		dto.setMemberid("mybaits5");
		dto.setName("박진주");
		dto.setPw(4444);// 3333 - 4444 변경
		dto.setPhone("010-3333-3336");
		dto.setEmail("mybatis4@au.com"); //jin@ju.com" - 변경
		String result = service.modifyMember(dto);
		System.out.println(result);
		*/
		
		//String result = service.deleteMember("mybaits4");
		//System.out.println(result);

		//int [] mypage = {0, 5};
		/*ArrayList<Integer> mypage = new ArrayList();
		mypage.add(0);
		mypage.add(5);
		
		List<MemberDTO> list = service.memberPagingList(mypage);
		*/

		// 1월가입 조회
		/*HashMap<String, String> map = new HashMap();
		map.put("colname", "regtime");//${colname}
		map.put("colvalue", "_____05%");//#{colvalue}
		List<MemberDTO> list = service.searchList(map);
		
		for(MemberDTO dto : list) {
			System.out.println(dto);
		}*/
		
	/*	MemberDTO searchDTO = new MemberDTO("data", null, 1111, null, null, null);
		List<MemberDTO> list = service.searchList2(searchDTO);
		for(MemberDTO dto : list) {
			System.out.println(dto);
		}*/
		
		MemberDTO dto = service.totalsql("datasource");
		System.out.println(dto);		
		
	}

}








