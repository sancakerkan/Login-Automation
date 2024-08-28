package com.example;

import org.testng.annotations.Factory;

public class LoginTestFactory {

    @Factory
    public Object[] createTests() {
        return new Object[] {
                new FirefoxLoginTest(),
                new ChromeLoginTest()
        };
    }
}