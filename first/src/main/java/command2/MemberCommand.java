package command2;

import org.springframework.stereotype.Component;

@Component("member")
public class MemberCommand implements Command {

	@Override
	public String run() {
		return "회원 : 관리중입니다";
	}

}
