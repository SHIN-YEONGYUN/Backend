package springmvc;

import java.util.HashMap;

public class HandlerMapping {
 // /hello url --- HelloController 컨트롤러에게 전달
	HashMap<String, Controller> mappings;
	HandlerMapping (){
		mappings = new HashMap<String, Controller>();
		mappings.put("hello", (Controller) new HelloController());
		mappings.put("list", (Controller) new ListController());
	}
	
	Controller getController(String url){
		return mappings.get(url);
	}
}
