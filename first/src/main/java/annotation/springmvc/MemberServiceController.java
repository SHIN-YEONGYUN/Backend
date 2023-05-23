package annotation.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberServiceController {
	@Autowired 
	@Qualifier("basicservice")
	MemberService basicservice;
	
	@Autowired
	@Qualifier("janservice")
	MemberService janservice;
	
	
	@GetMapping("/memberservice")
	public String memberservice() {
		return "memberservice";
	}
	
	@PostMapping("/memberservice")
	public ModelAndView memberserviceresult(MemberDTO dto) {//form 요청파라미터명=멤버변수명 자동 저장
	ModelAndView mv = new ModelAndView();
	//1월가입자 처리 MemberJANsERVICE REGISTERMEMBER() 메소드 호출
	System.out.println(dto.getRegtime().split("-")[1]);//2자리월  '01' 이면 1월 회원가입자
	String month = dto.getRegtime().split("-")[1];
	String result = null;
	if(month.equals("01")) {
		result = janservice.registerMember(dto);
	}
	else {
		result = basicservice.registerMember(dto);
	}

	mv.addObject("result",result);
	mv.setViewName("memberserviceresult");
	return mv;
	}
	
}
