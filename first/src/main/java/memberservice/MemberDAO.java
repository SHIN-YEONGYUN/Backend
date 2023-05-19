package memberservice;

public class MemberDAO {
	MemberDTO dto ;
	
	public void setDto(MemberDTO dto) {
		this.dto = dto;
	}

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
