package Return;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import annotation.springmvc.LoginDTO;

@Controller
public class ReturnTypeController {
	@RequestMapping("WEB-INF/views/a")
	public ModelAndView a() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", "a메소드 호출결과");
		mv.setViewName("aa");
		return mv;
	}
	@RequestMapping("/b")
	public String b() {
		return "bb";
	}
	@RequestMapping("/d")
	public void d(@ModelAttribute("dto")LoginDTO dto) {
		System.out.println("리턴타입 void입니다.");
	}
	@RequestMapping("/e")
	public String e() {
		//return "aa";
		return "redirect:/a";
	}
}
