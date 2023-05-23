package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnTypeController {
	@RequestMapping("/a")
	public ModelAndView a() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", "a메소드호출결과");
		mv.setViewName("aa");
		return mv;
	}
	@RequestMapping("/b")
	public String b() {
		return "bb";// 시작페이지 폼화면뷰
	}
	@RequestMapping("/c")	
	public void ccc() {
		System.out.println("리턴타입 void 입니다");
		//뷰이름 c.jsp
	}
	@RequestMapping("/d")	
	public void d(@ModelAttribute("dto") LoginDTO dto) {//요청파라미터---모델
		System.out.println("리턴타입 void 입니다");
		//뷰이름 d.jsp  ${dto.memberid} 
	}
	
	@RequestMapping("/e")
	public String e() {
		//return "aa";//aa.jsp 뷰(모델정보 없다)
		return "redirect:/a";  // /a url 메소드 실행-모델정보 있다-aa.jsp 뷰
	}
}
/*  WEB-INF/views/aa.jsp
 *  ${model}
 * 
 * */
 