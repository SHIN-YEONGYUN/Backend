package ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjaxController {
	@RequestMapping("/ajaxstart")
	public String ajax1test() {
		return "ajax/start";
	}
}
