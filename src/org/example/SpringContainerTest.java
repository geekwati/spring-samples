package org.example;

import org.example.db.UtilTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContainerTest {
	private static UtilTest utilTest;
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring_beans_h2.xml");
			utilTest = (UtilTest)context.getBean("utilTest");
			utilTest.test();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}