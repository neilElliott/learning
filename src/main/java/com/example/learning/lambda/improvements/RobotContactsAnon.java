package com.example.learning.lambda.improvements;

import com.example.learning.lambda.domain.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Before lambda expressions, anonymous inner classes were an option. For example, an interface (MyTest.java)
 * written with one test method that returns a boolean (a functional interface) is a possible solution.
 * The search criteria could be passed when the method is called.
 */
@Slf4j
public class RobotContactsAnon {
    public void phoneContacts(List<Person> personList, MyTest<Person> personTest) {
        for (Person person : personList) {
            // The test implementation is determined by the functional interface implementation
            // (anonymous inner class) passed into the method by the caller (see RobotCallTest03.java)
            if (personTest.test(person)) {
                ContactUtil.robotCall(person);
            }
        }
    }

    public void emailContacts(List<Person> personList, MyTest<Person> personTest) {
        for (Person person : personList) {
            if (personTest.test(person)) {
                ContactUtil.robotEmail(person);
            }
        }
    }

    public void postMailContacts(List<Person> personList, MyTest<Person> personTest) {
        for (Person person : personList) {
            if (personTest.test(person)) {
                ContactUtil.robotPostalMail(person);
            }
        }
    }
}
