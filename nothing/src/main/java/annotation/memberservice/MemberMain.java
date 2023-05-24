package annotation.memberservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.MyConfig;

@Configuration
@ComponentScan(basePackages = "annotation.memberservice")
public class MemberMain {


	public static void main(String[] args) {
		
		ApplicationContext factory = new
		ClassPathXmlApplicationContext("annotation/memberservice/member.xml");		

        for (String beanName : factory.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        ApplicationContext membermain =  new AnnotationConfigApplicationContext(MemberMain.class);
        for (String beanName : membermain.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        
        //MemberService service = membermain.getBean("janservice", MemberService.class);
        //service.registerMember();

		        
    	/*ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(MyConfig.class);
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        ArrayList<Integer> list = applicationContext.getBean("getList",ArrayList.class);
        System.out.println(list.get(0) + 200);
        */
	    }

}
