package annotation.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//crud기능 - create / read / update / delete - MemberCRUDController 

@Controller
public class LoginAllController{

	//@RequestMapping(value="/login" , method=RequestMethod.GET)  //get - 브라우저 주소 입력, <a href="", <form method=get , <form 
	
	@GetMapping("/login")
	// @RequestMapping 선언 메소드 리턴타입 String - view이름 간주
	public String form() {
		return "loginform";
	}
	
	//test5
	@PostMapping("/login")
	//@xxxmAPPING 메소드 매개변수로 클래스 선언 - 클래스 멤버변수명 = 요청파라미터명 , 타입 자동 주입하고 해당 객체를 모델로 자동 저장
	public String result(@ModelAttribute LoginDTO dto) {	// 요청 --스프링 CharacterEncodingFilter xml - 처리  --- 응답
		return "loginresult";
	}
	
	//test4
	/*@PostMapping("/login")
	//@xxxmAPPING 메소드 매개변수로 클래스 선언 - 클래스 멤버변수명 = 요청파라미터명 , 타입 자동 주입
	public ModelAndView result(LoginDTO dto) {	// 요청 --스프링 CharacterEncodingFilter xml - 처리  --- 응답
		ModelAndView mv = new ModelAndView();
		mv.addObject("logindto" , dto);
		mv.setViewName("loginresult");
		return mv;
	}*/
	
	//test3
	/*@PostMapping("/login")
	public ModelAndView result(@RequestParam(value="memberid" , required = false, defaultValue="spring" ) String id, int pw ) throws Exception  {
		//request.setCharacterEncoding("utf-8"); 
		// 요청 --스프링 CharacterEncodingFilter xml - 처리  --- 응답
		ModelAndView mv = new ModelAndView();
		//String memberid = request.getParameter("memberid");
		//int pw = Integer.parseInt(request.getParameter("pw"));
		LoginDTO dto = new LoginDTO();
		dto.setMemberid(id);
		dto.setPw(pw);
		mv.addObject("logindto" , dto);
		mv.setViewName("loginresult");
		return mv;
	}*/
	
	//test2
	/*@PostMapping("/login")
	//@xxxxMapping 메소드 매개변수 요청파라미터이름 동일하다면 자동 저장
	public ModelAndView result(String memberid, int pw ) throws Exception  {
		ModelAndView mv = new ModelAndView();
		LoginDTO dto = new LoginDTO();
		dto.setMemberid(memberid);
		dto.setPw(pw);
		mv.addObject("logindto" , dto);
		mv.setViewName("loginresult");
		return mv;
	}*/
	
	//test1
	//@RequestMapping(value="/login" , method=RequestMethod.POST)  //post - <form method=post 설정 있을 때에만
	/*@PostMapping("/login")
	public ModelAndView result(HttpServletRequest request) throws Exception  {
		//request.setCharacterEncoding("utf-8"); 
		// 요청 --스프링 CharacterEncodingFilter xml - 처리  --- 응답
		ModelAndView mv = new ModelAndView();
		String memberid = request.getParameter("memberid");
		int pw = Integer.parseInt(request.getParameter("pw"));
		LoginDTO dto = new LoginDTO();
		dto.setMemberid(memberid);
		dto.setPw(pw);
		mv.addObject("logindto" , dto);
		mv.setViewName("loginresult");
		return mv;
	}*/
	

}
