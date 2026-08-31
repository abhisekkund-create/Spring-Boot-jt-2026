package com.jt;

import org.springframework.stereotype.Component;

@Component
public class Greeting {

 public Greeting(){
        System.out.println("greeting object is constructed...");
    }

    public void sayhii(){
        System.out.println("hello greeting method");
    }
    
}
