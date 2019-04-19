package com.example.learning.lambda.improvements;

@FunctionalInterface
public interface MyTest<T> {
    boolean test(T t);
}
