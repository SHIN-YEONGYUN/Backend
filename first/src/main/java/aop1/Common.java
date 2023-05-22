package aop1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class Common {
	@Pointcut("execution (* aop1..*.*(..)")
	public void pc() {

	}

	long starttime = System.currentTimeMillis();

	@Before("pc()")
	public void a() { // 메소드 시작 이전
		System.out.println(new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초").format(new Date(starttime)));

	}

	@After("pc()")
	public void b() { // 메소드 종료 다음
		long endtime = System.currentTimeMillis();
		System.out.println(new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초").format(new Date(endtime)));

		System.out.println("메소드 수행시간(1/1000초)=" + (endtime - starttime));
	}

	@Around("pc()")
	public void c(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("메소드수행 이전입니다.");
			// target 메소드 실행
			Object obj = joinpoint.proceed();
			if (obj != null)
				System.out.println("target 메소드 리턴값 = " + obj);
			System.out.println("클래스이름 =" + joinpoint.getTarget());
			System.out.println("메소드이름 =" + joinpoint.toShortString());
			Object[] args = joinpoint.getArgs();
			for (Object o : args) {
				System.out.println("메소드매개변수 =" + o);
			}
			System.out.println("메소드수행 이후입니다.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}