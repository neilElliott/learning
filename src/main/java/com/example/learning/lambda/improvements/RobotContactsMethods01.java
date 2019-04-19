package com.example.learning.lambda.improvements;

import com.example.learning.lambda.domain.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * This design has some negative aspects:
 * The DRY principle is not followed.
 * Each method repeats a looping mechanism.
 * The selection criteria must be rewritten for each method
 * A large number of methods are required to implement each use case.
 * The code is inflexible. If the search criteria changed, it would require a number of code changes for an update.
 * Thus, the code is not very maintainable.
 */
@Slf4j
public class RobotContactsMethods01 {

    public void callPlayers(List<Person> personList) {
        for (Person person : personList) {
            if (person.getAge() >= 20 && person.getAge() <= 35) {
                ContactUtil.robotCall(person);
            }
        }
    }

    public void emailYouthPlayers(List<Person> personList) {
        for (Person person : personList) {
            if (person.getAge() <= 19) {
                ContactUtil.robotEmail(person);
            }
        }
    }

    public void mailAllPlayers(List<Person> personList) {
        for (Person person : personList) {
            if (person.getAge() >= 18) {
                ContactUtil.robotPostalMail(person);
            }
        }
    }
}
