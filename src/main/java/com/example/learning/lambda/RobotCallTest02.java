package com.example.learning.lambda;

import com.example.learning.lambda.domain.Person;
import com.example.learning.lambda.improvements.RobotContactsMethods02;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class RobotCallTest02 {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        RobotContactsMethods02 robot = new RobotContactsMethods02();

        log.info("==== Test 02 ====");
        log.info("=== Calling Players ===");
        robot.callPlayers(personList);

        log.info("=== Emailing Youth Players ===");
        robot.emailYouthPlayers(personList);

        log.info("=== Post Mail for All Players ===");
        robot.mailAllPlayers(personList);

    }
}
