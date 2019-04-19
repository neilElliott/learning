package com.example.learning.lambda;

import com.example.learning.lambda.domain.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class ComparatorTest {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();

        // Sort with Inner Class
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getSurName().compareTo(p2.getSurName());
            }
        });

        log.info("=== Sorted ascending surName ===");
        ComparatorTest.printNames(personList);

        // Sort with Lambda instead of inner class
        log.info("=== Sorted descending surName");

        /*
         * We added the person type in the argument list, however this is optional.
         * Lambda supports "target typing" which infers the object type from the context in which it is used.
         * Because we are assigning the result to a Comparator defined with a generic, the compiler can infer
         * that the two parameters are of the Person type.
         */
        Collections.sort(personList, (Person p1, Person p2) -> p2.getSurName().compareTo(p1.getSurName()));
        ComparatorTest.printNames(personList);

        log.info("=== Sorted ascending surName ===");

        // We can replace Collections.sort with list.sort.
        // Also, we can replace the lambda expression above with Comparator.comparing
        personList.sort(Comparator.comparing(Person::getSurName));
        ComparatorTest.printNames(personList);
    }

    private static void printNames(List<Person> personList) {
        personList.forEach(person -> log.info(person.toString()));
    }
}
