package com.codingshuttle.sakshi.cakebakery.impl;

import com.codingshuttle.sakshi.cakebakery.Frosting;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FrostingStrawberry implements Frosting {

    @Override
    public void getFrostingType(){
        System.out.println("Strawberry Frosting");
    }
}
