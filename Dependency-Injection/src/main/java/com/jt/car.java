package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class car {
    // private Engine engine1=new Engine();

    //Dependency injection

    //1.field injection
    // @Autowired
    // private Engine engine1;

    //2.setter method based injection

//     private Engine engine;

    
// @Autowired
//     public void setEngine(Engine engine1){
//         // System.out.println("parameter engine"+engine);
//         //  System.out.println("variable engine"+this.engine);
//         this.engine=engine1;
//     }

//constructioe based injection

private Engine engine;
@Autowired
public car(@Qualifier("disel")Engine engine){
    System.out.println("parametrized constructor..");
    this.engine=engine;
}

 public car(){
     System.out.println("nonparametrized constructor..");
    
 }


    public void startcar(){
        // Engine engine1=new Engine();
        engine.startengine();
        System.out.println("car is stared...");
    }


    public void stopcar(){

        //  Engine engine1=new Engine();
        engine.stopengine();
        System.out.println("car is stop....");

    }
    
}
