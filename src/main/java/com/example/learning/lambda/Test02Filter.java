package com.example.learning.lambda;

import com.example.learning.lambda.collections.SearchCriteria;
import com.example.learning.lambda.domain.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * In addition to looping through the contents of a collection, you can chain methods together.
 * The first method to look at is filter which takes a Predicate interface as a parameter.
 *
 * Notice that the stream method is called before filtering and looping begin. This method takes a
 * Collection as input and returns a java.util.stream.Stream interface as the output. A Stream
 * represents a sequence of elements on which various methods can be chained. By default, once
 * elements are consumed they are no longer available from the stream. Therefore, a chain of
 * operations can occur only once on a particular Stream. In addition, a Stream can be serial(default)
 * or parallel depending on the method called.
 */
@Slf4j
public class Test02Filter {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        SearchCriteria search = SearchCriteria.getInstance();

        log.info("=== Western name list ===");
        personList.stream()
                // Filter first based on the Predicate search criteria stored in the search criteria map
                .filter(search.getCriteria("activePlayers"))
                // After filtering, iterate over the remaining collection printing based on the
                // Western name print Predicate (method reference)
                .forEach(Person::printWesternName);

        log.info("=== Eastern name list ===");
        personList.stream()
                .filter(search.getCriteria("allPlayers"))
                .forEach(Person::printEasternName);
    }
}
