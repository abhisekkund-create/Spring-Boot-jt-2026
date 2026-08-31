package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Greet {

    private Greeting greeting;

    public Greet(){
        System.out.println(" greet object is constructed..");
    }
@Autowired
    public void setGreeting(Greeting greeting){
      this.greeting=greeting;
      System.out.println("greeting object is injected..");

    }
  public void greet(){
        System.out.println("hello Everyone....");
        // greeting.sayhii();
    }
@PostConstruct
    public void init(){
        System.out.println("bean is initialized....");

    }


    @PreDestroy
    public void destory(){
        System.out.println("greet beans is destroyed....");
    }

    
    
}
