package annotation.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Component , @Service , @Repository -- <context:compoent-scan ... >
@Controller  // <beans:bean id="hellocontroller"  class="springmvc.HelloController" />
public class HelloController  {
	@RequestMapping("/hello") // <beans:prop key="/hello">hellocontroller</beans:prop>
	public ModelAndView hello()  {
		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 jsp로 전달하는 모델입니다. --- 수정 ");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", dto);
		mv.setViewName("hello");
		return mv;
	}
	 
	@RequestMapping("/hello2")
	public ModelAndView hello2()  {
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", "hello2 url 실행중입니다.");
		mv.setViewName("hello2");
		return mv;
	}
	
	/*@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		//model생성
		//view정의-model전달
		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 jsp로 전달하는 모델입니다.");
		request.setAttribute("model", dto);
		return "hello.jsp";
	}*/

}
