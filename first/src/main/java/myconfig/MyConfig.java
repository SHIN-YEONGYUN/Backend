package myconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "command2")
public class MyConfig {

	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(MyConfig.class);
		String[] names = factory.getBeanDefinitionNames();
		for(String one : names) {
			System.out.println(one);
		}
	}

}
