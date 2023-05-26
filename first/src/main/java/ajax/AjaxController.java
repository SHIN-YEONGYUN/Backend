package ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AjaxController {

@RequestMapping("/ajaxstart")
public String ajax1test() {
	return "ajax/start";
}
/*
 * 1 .response.setContentType("text/html;charset=utf-8") 응답 뷰
 * 2. response.setContentType("application/download") 파일 다운로드 
 * 3. response.setContentType("application/json;charset=utf-8") ajax 응답
 * */
@RequestMapping(value="/ajaxlogin", produces= {"application/json;charset=utf-8"} )
@ResponseBody
public String ajaxlogin(String memberid, int pw) {
	// memberid : ajax 이고 pw : 1234 로그인성공 / 로그인실패
	String response = null;
	if(memberid.equals("ajax") && pw==1234) {
		response =  "로그인성공";
	}
	else {
		response = "로그인실패";
	}
	return "{ \"loginresult\" : \"" + response +  "\"}"; 
	
}

@RequestMapping(value="/ajaxmypage", produces= {"application/json;charset=utf-8"} )
public @ResponseBody MemberDTO ajaxmypage(String memberid, int pw) {
	MemberDTO dto = new MemberDTO();
	if(memberid.equals("ajax") && pw==1234) {
		dto.setMemberid(memberid);
		dto.setPw(pw);
		dto.setName("박정보");
		dto.setPhone("010-2222-3333");
		dto.setEmail("jung@a.com");
		dto.setRegtime("2023-05-26");
	}
	else {
		dto.setMemberid(memberid);
		dto.setPw(pw);
	}
	return dto; //자바객체 - JSON 변환 라이브러리 - JSON - 응답
}

@RequestMapping(value="/ajaxlist", produces= {"application/json;charset=utf-8"} )
public @ResponseBody ArrayList<MemberDTO> ajaxlist() {
	ArrayList<MemberDTO> list = new ArrayList();
	for(int i = 1; i <= 5 ; i++) {
		MemberDTO dto = new MemberDTO();
		dto.setMemberid("ajax" + i);
		dto.setPw(i);
		dto.setName("박정보" + i);
		dto.setPhone("010-2222-3333" +i);
		dto.setEmail("jung@a.com" +i);
		dto.setRegtime("2023-05-26" + i);
		list.add(dto);
	}

	return list; //자바객체 - JSON 변환 라이브러리 -  JSON 배열 - 응답
}

@RequestMapping(value="/getpw/{id}/{name}", produces= {"application/json;charset=utf-8"})
public @ResponseBody String ajaxpassword(@PathVariable("id") String memberid, @PathVariable("name") String n) {
	if(memberid.equals("ajax5")){
		//return 5555;
		String pw="555555";
	pw =pw.substring(0, 2) + "*".repeat(pw.length()-2);
	return "{\"pw\" : \"" +  pw + "\"}";
	}else {
		return "{\"pw\" : \" 모름 \"}";
	}
}
	@RequestMapping(value="ajaxupload", produces= {"application/json;charset=utf-8"})
	public @ResponseBody String ajaxupload(MultipartFile uploadfile) throws IOException {
		String savePath = "/Users/shin-yeongyun/Documents/upload/";
		String newFilename1 = null;
		if(!uploadfile.isEmpty()) {
		String originalname1 = uploadfile.getOriginalFilename();
		String beforeext1 = originalname1.substring(0, originalname1.indexOf("."));//pom
		String ext1 = originalname1.substring(originalname1.indexOf("."));//xml
		newFilename1 = beforeext1 + "(" + UUID.randomUUID().toString() +  ")" +  ext1;
		uploadfile.transferTo(new java.io.File(savePath + newFilename1 ));
		}//if
		return "{\"uploadresult\" : \"서버에 저장했습니다.\"}";
}

}
