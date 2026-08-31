package com.javatechnocrat.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.teacher;
@ImportResource("beans.xml")
@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class HelloApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(HelloApplication.class, args);
		//1.using xml file 
		green green=context.getBean(green.class);
		green.sayhello();
		
//2.using sterio type annotation
		person person1=context.getBean(person.class);
		person1.sayhello();

		//3.using configuration file
		student ss=context.getBean(student.class);
		ss.sayhello();

		teacher teache=context.getBean(teacher.class);
		teache.sayhello();

		System.out.println(teache.hashCode());

		teacher teache1=context.getBean(teacher.class);
		teache.sayhello();

		System.out.println(teache1.hashCode());

	}

	

}
