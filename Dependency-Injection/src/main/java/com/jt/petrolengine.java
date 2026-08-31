package com.jt;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("petrol")
 @Primary
public class petrolengine implements Engine {

    @Override
    public void startengine() {
        // TODO Auto-generated method stub
        System.out.println("petrol engine starting..");
    }

    @Override
    public void stopengine() {
        // TODO Auto-generated method stub
         System.out.println("petrol engine stop..");
    }
    
}
