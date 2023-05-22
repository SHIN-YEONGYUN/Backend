package annotation.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository // memberDAO 이름 bean 기본
public class MemberDAO {
	@Autowired // 1> MemberDTO 타입 생성 객체 1개면 자동 주입 2>여러개면 @Qualifier 선택
	@Qualifier("dto2")
	MemberDTO dto;
	//public void setDto(MemberDTO dto) {
	//	this.dto = dto;
	//}

	public boolean selectMember() {
		if(dto.getMemberid().equals("spring") && 
				dto.getPw()== 1111) {
			return true;//정상로그인사용자(이미존재id)
		}
		else {
			return false;
		}
	}
	
	public void insertMember() {
		System.out.println(dto.getMemberid() + " 회원님 정상적으로 회원가입되셨습니다.");
	}
}
