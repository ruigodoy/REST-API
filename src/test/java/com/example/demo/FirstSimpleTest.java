package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstSimpleTest {
    @Test
    public void test(){
        Assertions.assertAll(
                () -> Assertions.assertTrue(true),
                () -> Assertions.assertTrue(true),
                () -> Assertions.assertTrue(true)
        );
    }
}
