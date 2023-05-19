package annotation.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	MemberDTO dto;

	public void setDto(MemberDTO dto) {
		this.dto = dto;
	}

	public boolean selectMember() {
if(dto.getMemberid().equals("spring") && dto.getPw()==1111) {
	return true; // 정상로그인 사용자 (이미 존재 id)
}else {
	return false;
}
	}
	public void insertMember() {
		System.out.println(dto.getMemberid()+" 회원님 정상적으로 회원가입되었습니다.");
	}
}
