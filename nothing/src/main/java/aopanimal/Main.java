package aopanimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		Animal[] animal = new Animal[3];
		ApplicationContext factory = new ClassPathXmlApplicationContext("aopanimal/animal.xml");
		animal[0] = factory.getBean("cat", Animal.class);
		animal[1] = factory.getBean("dog", Animal.class);
		animal[2] = factory.getBean("rabbit", Animal.class);
		
		for(Animal a : animal) {
			a.lunch();
		}
		
		/* 1. aopanimal/animal.xml 파일 정의
		 * <bean 태그 사용하여 캣 도그 래빗 객체 빈 생성>
		 * 2. Main 클래스에 1번 정의한 bean 객체 가져와서 animal 배열에 저장
		 * 3. animal 배열내부 각 객체들 lunch 메소드 호출
		 * 4. 오늘은 뭐 먹을거에요
		 * Cat / Dog / Rabbit
		 * 먹었습니다.
		 * 5. AnimalAdvice 클래스 정의 - reply 메소드 공통관심 메소드 호출
		 * 6. aopanimal / animal.xml - aop설정 - aopanimal 패키지 lunch 메소드 적용
		 */
	}

}
