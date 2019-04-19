package com.example.learning.lambda.improvements;

import com.example.learning.lambda.domain.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * To fix {@link RobotContactsMethods01}, the search criteria is a good place to start. If test conditions are
 * isolated in separate methods, that would be an improvement.
 * <p>
 * The search criteria are encapsulated in a method, an improvement over the previous example. The test
 * conditions can be reused and changes flow back throughout the class. However there is still a lot of
 * repeated code and a separate method is still required for each use case. Is there a better way to pass
 * the search criteria to the methods?
 */
@Slf4j
public class RobotContactsMethods02 {

    public void callPlayers(List<Person> personList) {
        for (Person person : personList) {
            if (isPlayer(person)) {
                ContactUtil.robotCall(person);
            }
        }
    }

    public void emailYouthPlayers(List<Person> personList) {
        for (Person person : personList) {
            if (isYouthPlayer(person)) {
                ContactUtil.robotEmail(person);
            }
        }
    }

    public void mailAllPlayers(List<Person> personList) {
        for (Person person : personList) {
            if (isAllPlayerTypes(person)) {
                ContactUtil.robotPostalMail(person);
            }
        }
    }

    private boolean isPlayer(Person person) {
        return person.getAge() >= 20 && person.getAge() <= 35;
    }

    private boolean isYouthPlayer(Person person) {
        return person.getAge() <= 19;
    }

    private boolean isAllPlayerTypes(Person person) {
        return person.getAge() >= 18;
    }
}
