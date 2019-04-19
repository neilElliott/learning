package com.example.learning.lambda;

import com.example.learning.lambda.domain.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Test01ForEach {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();

        log.info("=== Western name list ===");
        // Can use method references like below instead of lambda
        personList.forEach(person -> person.printWesternName());

        log.info("=== Eastern name list ===");
        // Method reference: In a case where a method already exists to perform an operation on the class,
        // this syntax can be used instead of the normal lambda expression syntax.
        personList.forEach(Person::printEasternName);

        log.info("=== Custom name list ===");
        // Call custom print which requires a Predicate defined as a lambda
        personList.forEach(person -> log.info(
                    person.printCustom(r -> "Name: " + r.getGivenName() + " " + r.getSurName() + " #" + r.getNumber())
            )
        );
    }
}
