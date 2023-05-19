package command2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommandMain {
	public static void main(String args[]) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("command2/command.xml");
		Command[] mycommand = new Command[3];
		mycommand[0] = factory.getBean("board",Command.class);
		mycommand[1] = factory.getBean("member",Command.class);
		mycommand[2] = factory.getBean("product",Command.class);
		
		for(Command com : mycommand) {
			String result = com.run();
			System.out.println(result);
		}
//		BoardCommand bc = factory.getBean("board",BoardCommand.class);
//		bc.insertBoard();
//		mycommand[4] =bc;
	}
}
