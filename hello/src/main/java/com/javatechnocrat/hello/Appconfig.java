package com.javatechnocrat.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Appconfig {
    @Bean
    public student students(){
        // student ss=new student();
        // return ss;

        return new student();
    }

     @Bean
    public CommandLineRunner commandLineRunner(){
        return args ->{
            System.out.println("this method is called after spring container is initialized");
        };
    }

    
    
}
