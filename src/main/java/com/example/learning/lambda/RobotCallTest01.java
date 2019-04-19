package com.example.learning.lambda;

import com.example.learning.lambda.domain.Person;
import com.example.learning.lambda.improvements.RobotContactsMethods01;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class RobotCallTest01 {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        RobotContactsMethods01 robot = new RobotContactsMethods01();

        log.info("==== Test 01 ====");
        log.info("=== Calling Players ===");
        robot.callPlayers(personList);

        log.info("=== Emailing Youth Players ===");
        robot.emailYouthPlayers(personList);

        log.info("=== Post Mail for All Players ===");
        robot.mailAllPlayers(personList);

    }
}
