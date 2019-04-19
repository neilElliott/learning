package com.example.learning.lambda;

import com.example.learning.lambda.domain.Person;
import com.example.learning.lambda.improvements.RobotContactsLambda;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;

/**
 * That is definitely another improvement, because only three methods are needed to perform robotic operations.
 * However, there is a slight problem with ugliness when the methods are called. Check out the test class used
 * for this class.
 * <p>
 * This is a great example of the "vertical" problem in practice. This code is a little difficult to read.
 * In addition, we have to write custom search criteria for each use case.
 */
@Slf4j
public class RobotCallTest04 {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        RobotContactsLambda robot = new RobotContactsLambda();

        /*
         * Predicates:
         * Notice that a Predicate is set up for each group: allDrivers, allDraftees, and allPilots. You can
         * pass any of these Predicate interfaces to the contact methods. The code is compact and easy to read,
         * and it is not repetitive.
         */
        Predicate<Person> activePlayers = person -> person.getAge() >= 20 && person.getAge() <= 35;
        Predicate<Person> youthPlayers = person -> person.getAge() <= 19;
        // Use lambda directly below instead of defining a variable.
        // Predicate<Person> allPlayers = person -> person.getAge() >= 18;

        log.info("==== Test 04 ====");
        log.info("=== Calling Players ===");
        // Could just pass in the lambda right here instead of creating a variable above.
        robot.phoneContacts(personList, activePlayers);

        log.info("=== Emailing Youth Players ===");
        robot.emailContacts(personList, youthPlayers);

        log.info("=== Post Mail for All Players ===");
        robot.postMailContacts(personList, person -> person.getAge() >= 18);
    }
}
