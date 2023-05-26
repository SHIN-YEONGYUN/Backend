package board.spring.mybatis;


// servlet 4.0 미만 javax.servlet.hhtp.HttpServlet
// servlety 5.0 jakarta.servlet.....
import org.apache.ibatis.session.SqlSession;//mybatis(새로운이름) -  ibatis(이전이름)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession session;
	
	public MemberDTO oneMember(String id) {
		return session.selectOne("oneMember", id);
	}


}




