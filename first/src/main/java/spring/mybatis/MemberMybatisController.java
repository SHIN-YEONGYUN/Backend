package spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberMybatisController {
	@Autowired
	MemberService service;

	@RequestMapping("/memberlist")
	public ModelAndView memberList() {
		List<MemberDTO> list = service.memberList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist",list);
		mv.addObject("membercount",list.get(list.size()-1).getPw());
		mv.setViewName("mybatis/memberlist"); // WEB-INF/view/mybatis/*.jsp
		return mv;
	}
	@RequestMapping("/membersearchlist")
	public ModelAndView memberList(String item, String searchword) {
		System.out.println(item + ":" + searchword);
		ModelAndView mv = new ModelAndView();
		
	    MemberDTO dto = new MemberDTO();
	    HashMap map = new HashMap();
	    
	    if(item.contains("이름")) {
	    	dto.setName(searchword);
	    	map.put("colname", "name");
	    }else if (item.contains("번호")) {
	    	dto.setPhone(searchword);
	    	map.put("colname", "phone");
	    }else if (item.contains("이메일")) {
	    	dto.setEmail(searchword);
	    	map.put("colname", "email");
	    }else if (item.contains("아이디")) {
	    	dto.setMemberid(searchword);
	    	map.put("colname", "memberid");
	    }
	    map.put("colvalue","%"+searchword+"%");
	    List<MemberDTO> list = service.searchList(map);
	    //List<MemberDTO> list = service.searchList2(dto);
	    mv.addObject("memberlist",list);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
}
