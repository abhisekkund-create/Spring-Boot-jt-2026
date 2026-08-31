package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		 ApplicationContext context=SpringApplication.run(DependencyInjectionApplication.class, args);
		//  Engine engine=context.getBean(Engine.class);
		//  engine.startengine();
		car car1=context.getBean(car.class);
		car1.startcar();
		car1.stopcar();
		
	}

}
