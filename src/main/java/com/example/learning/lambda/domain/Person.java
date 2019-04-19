package com.example.learning.lambda.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Data
@AllArgsConstructor
@Builder
@Slf4j
public class Person {
    private String givenName;
    private String surName;
    private int age;
    private int number;

    public static List<Person> createShortList() {
        return Arrays.asList(
                Person.builder()
                        .givenName("Christiano")
                        .surName("Ronaldo")
                        .age(29)
                        .number(7)
                        .build(),
                Person.builder()
                        .givenName("Paul")
                        .surName("Scholes")
                        .age(38)
                        .number(18)
                        .build(),
                Person.builder()
                        .givenName("Scott")
                        .surName("McTominay")
                        .age(18)
                        .number(37)
                        .build(),
                Person.builder()
                        .givenName("Ryan")
                        .surName("Giggs")
                        .age(41)
                        .number(11)
                        .build()
        );
    }

    public String printCustom(Function<Person, String> function) {
        return function.apply(this);
    }

    public void printWesternName() {
        log.info("{} {}", this.getGivenName(), this.getSurName());
    }

    public void printEasternName() {
        log.info("{}, {}", this.getSurName(), this.getGivenName());
    }
}
