package annotation.springmvc;

import java.util.HashMap;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {
	HashMap<String, Integer> moviemap = new HashMap();

	@RequestMapping("/movielist")
	public ModelAndView start(){
		moviemap.put("영화제목1", 19);
		moviemap.put("영화제목2", 13);
		moviemap.put("영화제목3", 19);
		moviemap.put("영화제목4", 0);
		ModelAndView mv = new ModelAndView();
		Set<String> movielist = moviemap.keySet();
		mv.addObject("movielist", movielist);
		mv.setViewName("movielist");
		return mv;

	}
	
	@RequestMapping("/moviereserve")
	ModelAndView end(String memberid, int pw, int age, String[] mymovielist){
		ModelAndView mv = new ModelAndView();
		//1. mymovielist 목록을 가져와서 moviemap key 일치하는지; 확인한다
		Set<String> movieSet = moviemap.keySet();
		String resultmovie = "";
		for(String mymovie : mymovielist) {
			for(String movie : movieSet) {
				if(movie.contains(mymovie) && moviemap.get(movie) <= age ) {
					resultmovie += movie + " ";
				}
			}
		}
		mv.addObject("memberid", memberid);
		mv.addObject("age", age);
		mv.addObject("resultmovie", resultmovie);
		mv.setViewName("moviereserve");
		return mv;

	}
	
}
