package spring;

public class LgTV implements TV{
	public void powerOn() {
		System.out.println("엘지티비 전원켜다");
	}
	public void powerOff() {
		System.out.println("엘지티비 전원끄다");
	}
	public void soundUp() {
		System.out.println("엘지티비 볼룸높이다");
	}
	public void soundDown() {
		System.out.println("엘지티비 볼룸낮추다");
	}
}
/*
 * 1> 2개객체 모두 동일 TV 메소드 가져야 한다
 * 2> TVFactory 통해서만 생성한다.
 * 3> tv객체 생성 주도권 TVFactory이다
 * 4> TVMain tv객체 사용하지만 <--- TVFactory 의존한다.
 * 5> 2객체 한정, 메소드 4개 동일
 * 6> 의존성 주입
 * */
