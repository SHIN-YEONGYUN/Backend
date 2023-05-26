package board.spring.mybatis;

public interface BoardService {
	public int insertBoard(BoardDTO dto);
	public int getTotalBoard();
}
