package com.example.learning.lambda;

import com.example.learning.lambda.domain.Person;
import com.example.learning.lambda.improvements.MyTest;
import com.example.learning.lambda.improvements.RobotContactsAnon;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * That is definitely another improvement, because only three methods are needed to perform robotic operations.
 * However, there is a slight problem with ugliness when the methods are called. Check out the test class used
 * for this class.
 * <p>
 * This is a great example of the "vertical" problem in practice. This code is a little difficult to read.
 * In addition, we have to write custom search criteria for each use case.
 */
@Slf4j
public class RobotCallTest03 {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        RobotContactsAnon robot = new RobotContactsAnon();

        log.info("==== Test 03 ====");
        log.info("=== Calling Players ===");
        robot.phoneContacts(personList, new MyTest<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() >= 20 && person.getAge() <= 35;
            }
        });

        log.info("=== Emailing Youth Players ===");
        robot.emailContacts(personList, new MyTest<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() <= 19;
            }
        });

        log.info("=== Post Mail for All Players ===");
        robot.postMailContacts(personList, new MyTest<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() >= 18;
            }
        });

    }
}
