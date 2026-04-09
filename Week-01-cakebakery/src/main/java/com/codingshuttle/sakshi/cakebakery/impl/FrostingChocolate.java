package com.codingshuttle.sakshi.cakebakery.impl;

import com.codingshuttle.sakshi.cakebakery.Frosting;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FrostingChocolate implements Frosting {
    @Override
    public void getFrostingType() {
        System.out.println("Frosting Chocolate");
    }
}
