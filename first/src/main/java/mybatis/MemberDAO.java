package mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<MemberDTO> memberList() {
		List<MemberDTO> list = session.selectList("memberList");
		return list;
	}

	public MemberDTO oneMember(String id) {
		return session.selectOne("oneMember", id);
	}

	public int memberCount() {
		return session.selectOne("memberCount");
	}

	public int insertMember(MemberDTO dto) {
		return session.insert("insertMemberDTO", dto);
	}

	public int updateMember(MemberDTO dto) {
		return session.update("updateMember", dto);
	}

	public int deleteMember(String id) {
		return session.delete("deleteMember", id);
	}

	// public List<MemberDTO> memberPagingList(int[] limit){
	public List<MemberDTO> memberPagingList(ArrayList limit) {
		return session.selectList("memberPagingList", limit);
	}

	public List<MemberDTO> searchList(HashMap<String, String> map) {
		return session.selectList("searchList", map);
	}

	public List<MemberDTO> searchList2(MemberDTO dto) {
		return session.selectList("searchList2", dto);
	}

	public MemberDTO totalsql(String id) {
		return session.selectOne("totalsql",id);
	}
}
