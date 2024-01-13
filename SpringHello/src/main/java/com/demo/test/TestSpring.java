package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.HelloSpring;
import com.demo.model.MyUser;

public class TestSpring {
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		System.out.println("HelloSpring Class=====>");
		HelloSpring h1=(HelloSpring) ctx.getBean("hw");
		System.out.println(h1);
		String s=h1.sayHello();
		System.out.println(s);
		
		
		System.out.println("MyUser Class=====>");
		System.out.println("Scope = Prototype");
		MyUser user1=(MyUser) ctx.getBean("u1");
		System.out.println(user1);
		System.out.println("Scope = Singleton");
		MyUser user2=(MyUser) ctx.getBean("u2");
		System.out.println(user2);
		System.out.println("Scope = Constructor");
		MyUser user3=(MyUser) ctx.getBean("u3");
		System.out.println(user3);
	}

}
