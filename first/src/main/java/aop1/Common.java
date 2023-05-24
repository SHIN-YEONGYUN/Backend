package aop1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
//@Component
public class Common {
	long starttime = System.currentTimeMillis();
	
	public void a() {//메소드시작이전
		System.out.println( 
		new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초").format(new Date(starttime)) 
		);
	}
	
	public void b() {//메소드종료다음
		long endtime = System.currentTimeMillis();
	//	System.out.println( 
	//	new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초").format(new Date(endtime)) 
	//	);
		
		System.out.println("메소드수행시간(1/1000초)=" + (endtime - starttime));
	}
	public void c(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("메소드수행 이전입니다");
			// 현재 target 메소드 실행해
			Object obj = joinpoint.proceed();
			//현재실행중인 클래스 / 메소드이름
			if (obj != null) System.out.println("target 메소드 리턴값 = "+ obj);
			System.out.println("클래스이름 = " + joinpoint.getTarget());
			System.out.println("메소드이름 = " + joinpoint.toShortString());
			
			Object [] args = joinpoint.getArgs();
			for(Object o :args) {
			System.out.println("메소드매개변수 = " + o);
			}
			System.out.println("메소드수행 이후입니다");
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}//c
}//Commonf




