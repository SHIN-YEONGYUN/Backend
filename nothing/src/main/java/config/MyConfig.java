package config;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
public class MyConfig {
   
    @Bean 
    ArrayList<Integer> getList(){
    	ArrayList list = new ArrayList();
    	list.add(100);
    	return list;
    	
    }
}
