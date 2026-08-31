package com.jt;

import org.springframework.stereotype.Component;

// @Component
// public class Engine {

//     public void startengine(){
//        System.out.println("engine is started....");
//     }
    

//      public void stopengine(){
//         System.out.println("engine is not starting...");
//     }
// }
public interface Engine {

    void startengine();
    void stopengine();
        
    
}