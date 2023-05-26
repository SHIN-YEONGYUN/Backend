package board.spring.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDAO dao;
	
	public int insertBoard(BoardDTO dto) {
		return dao.insertBoard(dto);
	}
	
	public int getTotalBoard() {
		return dao.getTotalBoard();
	}
}
