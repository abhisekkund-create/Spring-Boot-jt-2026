package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanLifeCycleApplication {

	public static void main(String[] args) {
	var context=SpringApplication.run(BeanLifeCycleApplication.class, args);
	var greet=context.getBean(Greet.class);
	greet.greet();
		
	}

	/*Bean life cycle

	1.Bean instanciated-object is created-constructor
	2.Dependedncy injection(if avilable)-by using any way of 
	3.Bean initialized-@postconstruct
	4.Bean used
	5.Bean destory-@preDestroy

	-managed by spring container
	 */
}
