package com.codingshuttle.sakshi.cakebakery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {
    private final Frosting frosting;
    private final Syrup syrup;

    public CakeBaker(
            @Qualifier("frostingChocolate") Frosting frosting,
                     @Qualifier("syrupStrawberry") Syrup syrup){
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake(){
         System.out.println("Cake baked with " );
         frosting.getFrostingType();
         syrup.getSyrupType();

    }

}
//“I used interfaces to achieve loose coupling,
// @Component to register beans,
// constructor-based dependency injection for better design,
// @Qualifier to resolve multiple implementations,
// and final fields to ensure immutability.”