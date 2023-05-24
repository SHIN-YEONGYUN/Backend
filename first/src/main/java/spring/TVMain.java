package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {
 public static void main(String args[]) {
	 //spring 에게 tv.xml 설정에 있는 객체들 생성 요청
	ApplicationContext factory = new ClassPathXmlApplicationContext("spring/tv/tv.xml");
	TV tv = (TV)factory.getBean("tv");
	//"틀/규칙/제한"
	
	 if(tv != null) {
	 tv.powerOn();
	 tv.soundUp();
	 tv.soundDown();
	 tv.powerOff();
	 }
 }
}
