package board.spring.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession session;
	
	public int insertBoard(BoardDTO dto) {
	return session.insert("insertBoard", dto);
	}
	
	public int getTotalBoard() {
		return session.selectOne("getTotalBoard");
	}
	
}
