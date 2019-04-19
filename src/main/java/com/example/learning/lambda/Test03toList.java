package com.example.learning.lambda;

import com.example.learning.lambda.collections.SearchCriteria;
import com.example.learning.lambda.domain.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * As previously mentioned, a Stream is disposed of after its use. Therefore, the elements in a
 * collection cannot be changed or mutated with a Stream. However, what if you want to keep
 * elements returned from your chained operations? You can save them to a new collection.
 */
@Slf4j
public class Test03toList {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        SearchCriteria search = SearchCriteria.getInstance();

        // Make a new list after filtering
        List<Person> playerList = personList
                .stream()
                .filter(search.getCriteria("youthPlayers"))
                // The collect method is called with one parameter, the Collectors class. The Collectors
                // class is able to return a List or Set based on the results of the stream. The example
                // shows how the result of the stream is assigned to a new List which is iterated over.
                .collect(Collectors.toList());

        log.info("=== Western name list ===");
        playerList.forEach(Person::printWesternName);
    }
}
