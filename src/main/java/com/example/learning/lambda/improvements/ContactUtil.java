package com.example.learning.lambda.improvements;

import com.example.learning.lambda.domain.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ContactUtil {
    private ContactUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    static void robotCall(Person person) {
        log.info("Calling {} {} #{}", person.getGivenName(), person.getSurName(), person.getNumber());
    }

    static void robotEmail(Person person) {
        log.info("Emailing {} {} #{}", person.getGivenName(), person.getSurName(), person.getNumber());
    }

    static void robotPostalMail(Person person) {
        log.info("Posting mail for {} {} #{}", person.getGivenName(), person.getSurName(), person.getNumber());
    }
}
