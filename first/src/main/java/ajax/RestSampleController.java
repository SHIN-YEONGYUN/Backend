package ajax;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RestSampleController {

	@RequestMapping("rest1")
	String rest1(){
		return "";
	}
	
	@RequestMapping("rest2")
	
	String rest2(){
		return "";
	}
	
	
	@RequestMapping("rest3")
	String rest3(){
		return "";
	}
}
