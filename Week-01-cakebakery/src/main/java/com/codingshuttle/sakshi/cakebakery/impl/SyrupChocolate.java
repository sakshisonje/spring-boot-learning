package com.codingshuttle.sakshi.cakebakery.impl;

import com.codingshuttle.sakshi.cakebakery.Syrup;
import org.springframework.stereotype.Component;

@Component
public class SyrupChocolate implements Syrup {

    @Override
    public void getSyrupType() {
        System.out.println("Syrup Chocolate");
    }
}
