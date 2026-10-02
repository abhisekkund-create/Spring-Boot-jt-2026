package com.example.jpa_annotation_concept;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor 
public class JpaAnnotationConceptApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAnnotationConceptApplication.class, args);
	}

	private final EmployeeRepository repository;

	@Bean 
	public CommandLineRunner commandLineRunner(){
		return args->{
			System.out.println("command line runner run method..");
			// Employee employee=new Employee();
			Employee employee=Employee.builder()
			.name("Ranjit")
			.description("Ranjit is loyal employee")
			.salary(BigDecimal.valueOf(100000.98))
			.employeeStatus(EmployeeStatus.ACTIVE)
			.build();

			Employee emp= repository.save(employee);
			Employee savedEmployee=repository.findById(emp.getId())
			.orElseThrow();
			System.out.println("saved employee"+savedEmployee);

			savedEmployee.setName("Ankit");
			savedEmployee.setDescription("Ankit is a good guy");

			repository.save(savedEmployee);
		};
	}

}
