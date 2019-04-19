package com.example.learning.lambda.improvements;

import com.example.learning.lambda.domain.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;

/**
 * In the previous example {@link RobotContactsAnon}, the {@link MyTest} functional interface passed anonymous
 * classes to methods. However, writing that interface was not necessary. Java SE 8 provides the
 * java.util.function package with a number of standard functional interfaces. In this case,
 * the Predicate interface meets our needs.
 */
@Slf4j
public class RobotContactsLambda {

    /**
     * Replace custom MyTest functional interface with exact same Java 8 implementation {@link Predicate}
     * @param personList a {@link List} of Persons
     * @param predicate {@link Predicate}
     */
    public void phoneContacts(List<Person> personList, Predicate<Person> predicate) {
        for (Person person : personList) {
            // The test implementation is determined by the functional interface implementation
            // (anonymous inner class) passed into the method by the caller (see RobotCallTest03.java)
            if (predicate.test(person)) {
                ContactUtil.robotCall(person);
            }
        }
    }

    public void emailContacts(List<Person> personList, Predicate<Person> predicate) {
        for (Person person : personList) {
            if (predicate.test(person)) {
                ContactUtil.robotEmail(person);
            }
        }
    }

    public void postMailContacts(List<Person> personList, Predicate<Person> predicate) {
        for (Person person : personList) {
            if (predicate.test(person)) {
                ContactUtil.robotPostalMail(person);
            }
        }
    }
}
