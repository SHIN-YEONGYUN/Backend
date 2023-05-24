package tv;

public class TVMain {
 public static void main(String args[]) {
	 //spring 제공하는 객체만 사용
	 TV tv =  new TVFactory().getTV(args[0]);

	 if(tv != null) {
	 tv.powerOn();
	 tv.soundUp();
	 tv.soundDown();
	 tv.powerOff();
	 }
 }
}
