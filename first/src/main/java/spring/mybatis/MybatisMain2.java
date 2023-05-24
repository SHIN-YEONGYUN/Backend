package spring.mybatis;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisMain2 {
	public static void main(String[] args) throws IOException {
		// SqlSession
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));
		SqlSession session = factory.openSession(true);

		MemberDAO dao = new MemberDAO();
		dao.setSession(session);

		MemberService service = new MemberServiceimpl();
		((MemberServiceimpl) service).setDao(dao);

//		List<MemberDTO> list = service.memberList();
//		System.out.println("총회원수 = "+list.get(list.size()-1).getPw());
//		for (int i=0; i<list.size()-1; i++) {
//			System.out.println(list.get(i));
//		}

//		MemberDTO dto = service.oneMember("jdbc2");
//		System.out.println("나의정보 = "+ dto);

//		
//		MemberDTO dto = new MemberDTO();
//		dto.setMemberid("mybatis4");
//		dto.setName("진돗개");
//		dto.setPw(2222);
//		dto.setPhone("010-2726-2024");
//		dto.setEmail("dotgae@jin.com");
//		String result = service.registerMember(dto);
//		System.out.println(result);
		/*
		 * memberid 해당 회원정보 MemberDTO 리턴 받기 - dao.xxxx 리턴받은 정보가 있다 - 아이디 중복 - 회원 가입 불가능
		 * 리턴받은 정보 없다 - dao.xxxx - 정상적으로 회원가입 되었다
		 */

//		MemberDTO dto = new MemberDTO();
//		dto.setMemberid("mybatis4");
//		dto.setName("진돗개");
//		dto.setPw(5555);
//		dto.setPhone("010-2726-2024");
//		dto.setEmail("dotgae2@jin.com");
//		String result = service.modifyMember(dto);
//		System.out.println(result);

//		String result = service.deleteMember("mybatis4");
//		System.out.println(result);

		// int[] mypage = {0,5};
//		ArrayList<Integer> mypage= new ArrayList();
//		mypage.add(0);
//		mypage.add(5);
//		List<MemberDTO> list = service.memberPagingList(mypage);

//		HashMap<String, String> map = new HashMap();
//		map.put("colname", "regtime");
//		map.put("colvalue", "_____05%");
//		List<MemberDTO> list = service.searchList(map);
//		for (MemberDTO dto : list) {
//			System.out.println(dto);
//		}

//		MemberDTO searchDTO = new MemberDTO("r", null, 1111, null, null, null);
//		List<MemberDTO> list = service.searchList2(searchDTO);
//		for (MemberDTO dto : list) {
//			System.out.println(dto);
//		}
		MemberDTO dto = service.totalsql("react");
		System.out.println(dto);
	}
}
