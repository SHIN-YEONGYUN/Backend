package mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisMain {

	public static void main(String[] args) throws IOException {
		//SqlSession = jdbc Connection 
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build( Resources.getResourceAsReader("mybatis/mybatis-config.xml") );
		//SqlSession session = factory.openSession(true); //auto commit 설정
		
		//SqlSession session = factory.openSession(); //commit(반영)/rollback(취소) 선택 결정
		SqlSession session = factory.openSession(false); //commit(반영)/rollback(취소) 선택 결정
		
		//전체리스트
		/*List<MemberDTO> list = session.selectList("memberList");
		for(MemberDTO dto : list) {
			System.out.println(dto.getMemberid() + ":" + dto.getName() + ":" + dto.getRegtime());
		}*/
		
		//1 회원의 정보
		//MemberDTO dto  = session.selectOne("oneMember", "datasource");
		//System.out.println(dto.getMemberid() + ":" + dto.getName() + ":" + dto.getRegtime());

		//결과 1개, int 
		//int count = session.selectOne("memberCount");
		//System.out.println("총 가입회원수 = " + count);
		
		//insert , delete, update 문장 - 테이블에 변화 sql  신중 - 즉각 db 반영하지 말고  commit(반영)/rollback(취소) 선택 결정
		/*int rows = session.insert("insertMember");
		System.out.println("가입회원수 = " + rows);//1
		session.commit();
		//session.rollback();
		*/
		
		/*MemberDTO dto = new MemberDTO();
		dto.setMemberid("mybaits3");
		dto.setName("박진주");
		dto.setPw(3333);
		dto.setPhone("010-3333-3335");
		dto.setEmail("jin@ju.com");
		//int rows2 =  session.insert("insertMemberDTO", dto );
		//System.out.println("가입회원수 = " + rows2);//1
		//session.commit();
		//<insert id="insertMemberDTO" parameterType="memberdto">
		*/
		
		/*MemberDTO dto = new MemberDTO();
		dto.setMemberid("mybaits3");
		//dto.setName("박진주");
		dto.setPw(3335);
		//dto.setPhone("010-3333-3335");
		dto.setEmail("parkjinju@edu.com");
		
		int rows = session.update("updateMember", dto );
		System.out.println("수정한 행갯수 = " + rows);
		//session.commit();
		*/
		
		int rows = session.delete("deleteMember", "mybaits3");
		System.out.println("삭제한 행갯수 = " + rows);
		session.commit();
		
	}

}








