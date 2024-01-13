package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.MyUser;

public class TestLifeCycle {

	public static void main(String[] args) {
		//BeanFactory bc=new XmlBeanFactory(new ClassPathResource("springconfig.xml"));
				ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
				MyUser user1=(MyUser) ctx.getBean("u1");
				System.out.println(user1);

	}

}
