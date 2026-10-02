package com.example.methods_of_jpa;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor 
public class MethodsOfJpaApplication {

	private final productRepository productRepository;
	private final OrderService orderService;

	

	public static void main(String[] args) {
		SpringApplication.run(MethodsOfJpaApplication.class, args);
	}

	@Bean 
	public CommandLineRunner commandLineRunner(){
		return args->{
			product product1=product.builder()
			.productName("Iphone")
			.productBrand("Apple")
			.productPrice(1800000.00)
			.build();

			// //save
			//  product savedProduct=productRepository.save(product1);
			//  System.out.println("saved product is"+savedProduct);

			 //save All
			 productRepository.saveAll(getProduct());

			 //count
			//  long count=productRepository.count();
			//  System.out.println("total number of product is"+count);

		
		  //Exists & Exists by ID
			// boolean isIphoneExists=productRepository.existsById(1);
			// System.out.println("is iphone i7 exists"+isIphoneExists);

			//delete by id
		productRepository.deleteById(7);

			//delete all
			// List<product>products=productRepository.findAll();
			// productRepository.deleteAll(products);


			// List<product>products=productRepository.findAll(Sort.by(Direction.DESC,"productName"));
			// products.forEach(System.out::println);




			//how to update the data
			// product apple=productRepository.findById(34).orElseThrow();
			// apple.setProductBrand("Samsung");
			// productRepository.save(apple);


			// Page<product>products=productRepository.findAll(PageRequest.of(1, 5,Direction.DESC,"productId"));
			//  products.forEach(System.out::println);


            
	//   product optGalaxy=productRepository.findByProductName("Galaxy S24 Ultra").orElseThrow();
	//   System.out.println(optGalaxy);

	productRepository.findAllByProductPriceBetween(10000, 80000)
	.forEach(System.out::println);



	// productRepository.findByProductNameAndProductBrand("Mechanical Gaming Keyboard", "Logitech")
	// .ifPresent(p->System.out.println(p));


	// productRepository.getProduct("Iphone", "Apple")
	// .ifPresent(p->System.out.println(p));

	// int affectedRow=productRepository.updatePrice(1, 130000.00);
	// System.out.println("no of affected rows"+affectedRow);

	orderService.placeOrder(1, 10);



		};
	}

	private List<product>getProduct(){
		 return IntStream.range(1, 11).mapToObj(i->product.builder()
		.productName("product"+i)
		.productBrand("brand"+i)
		.productPrice(1000*i)
		.build())
		.toList();
		}

}
