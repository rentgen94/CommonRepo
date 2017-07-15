package ru.example.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.example.impls.robot.ModelT1000;

public class Start {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Object obj = context.getBean("t1000");
		if (obj instanceof ModelT1000) {
			ModelT1000 t1000 = (ModelT1000) context.getBean("t1000");
			t1000.action();
		}
		((ConfigurableApplicationContext)context).close();// закрытие контекста вручную
	}
}
