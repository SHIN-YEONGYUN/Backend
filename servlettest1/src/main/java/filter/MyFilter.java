package filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

//@WebFilter("/*")
public class MyFilter extends HttpFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter
	(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//요청 - 필터(요청 작업 추가) - 또다른필터- 서블릿 실행 - 필터(응답 작업 추가) - 서블릿 - 응답
		System.out.println("Filter 시작");
		//모든 서블릿 서블릭이름, 클라이언트ip, 요청시간
		String servletname = ((HttpServletRequest)request).getServletPath();
		String ip = request.getRemoteAddr();
		//0:0:0:0:0:0:0:1(127.0.0.1(ipv4)의 ip6 표현방식)
		
		String now = new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초").format(new Date());
		System.out.println(servletname + ":" + ip +":" + now);  //또는 파일 저장 매일
		
		
		//servlet 4.0 post 요청 한글설정 
		/*if(((HttpServletRequest)request).getMethod().equals("POST")) {
			request.setCharacterEncoding("utf-8");
		}*/
		long start = System.currentTimeMillis();
		chain.doFilter(request, response);//그다음 필터로 넘겨라. 없으면 해당 서블릿 호출 실행
		long end = System.currentTimeMillis();
		System.out.println( (end-start) +  " 소요(1/1000초)");
		
		//필터에설정(서블릿 해당문장 주석)
		//응답파일 xls, image,  파일명 
		response.setContentType("text/html;charset=utf-8");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
