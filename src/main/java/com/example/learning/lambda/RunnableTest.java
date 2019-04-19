package com.example.learning.lambda;

import lombok.extern.slf4j.Slf4j;

/**
 * With Java SE 8, an interface that follows the pattern of having only one method is known as a
 * "functional interface."
 * <p>
 * Using functional interfaces with anonymous inner classes are a common pattern in Java.
 * In addition to the EventListener classes, interfaces like Runnable and Comparator are used in a similar manner.
 * Therefore, functional interfaces are leveraged for use with lambda expressions.
 */
@Slf4j
public class RunnableTest {
    public static void main(String[] args) {

        log.info("=== RunnableTest ===");

        // Anonymous inner class Runnable
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                log.info("hello world one!");
            }
        };

        // Lambda Runnable can replace the anonymous inner class above.
        Runnable r2 = () -> log.info("Hello world two!");

        // Run
        r1.run();
        r2.run();
    }
}
