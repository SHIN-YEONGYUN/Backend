package command2;

import org.springframework.stereotype.Component;

@Component("board")
public class BoardCommand implements Command {

	
	public String run() {
		return "게시판 : 실행중입니다.";
	}
	
	public void insertBoard() {
		System.out.println("BoardCommand : insertBoard");
	}
	int seq;
}
