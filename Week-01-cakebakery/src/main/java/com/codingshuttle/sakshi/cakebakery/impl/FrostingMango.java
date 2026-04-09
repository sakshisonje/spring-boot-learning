package com.codingshuttle.sakshi.cakebakery.impl;

import com.codingshuttle.sakshi.cakebakery.Frosting;
import org.springframework.stereotype.Component;

@Component
public class FrostingMango implements Frosting {
    @Override
    public void getFrostingType() {
        System.out.println("Frosting Mango");
    }
}
