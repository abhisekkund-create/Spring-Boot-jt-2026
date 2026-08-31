package com.jt;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("disel")
@Primary
public class diselengine implements Engine {
    

    @Override
    public void startengine() {
        // TODO Auto-generated method stub
       System.out.println("disel engine started...");
    }

    @Override
    public void stopengine() {
        // TODO Auto-generated method stub
       System.out.println("disel engine stop...");
    }
    
}
