package com.example.learning.lambda;

import com.example.learning.lambda.collections.SearchCriteria;
import com.example.learning.lambda.domain.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * As previously mentioned, a Stream is disposed of after its use. Therefore, the elements in a
 * collection cannot be changed or mutated with a Stream. However, what if you want to keep
 * elements returned from your chained operations? You can save them to a new collection.
 */
@Slf4j
public class Test04Map {
    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        SearchCriteria search = SearchCriteria.getInstance();

        // calculate average age of all players old style
        log.info("=== Calculate average age old style ===");

        int sum = 0;
        int count = 0;

        for (Person person : personList) {
            sum = sum + person.getAge();
            count++;
        }

        long average = sum / count;
        log.info("Total ages: {}", sum);
        log.info("Average age: {}", average);

        // Get sum of ages
        log.info("=== Calculate average age NEW style ===");
        long totalAge = personList
                .stream()
                .filter(search.getCriteria("allPlayers"))
                // Can use method reference like below, instead of lambda
                .mapToInt(person -> person.getAge())
                .sum();

        // Get average of ages
        OptionalDouble averageAge = personList
                .parallelStream()
                .filter(search.getCriteria("allPlayers"))
                .mapToDouble(Person::getAge)
                .average();

        log.info("Total ages: {}", totalAge);
        log.info("Average age: {}", averageAge.getAsDouble());
    }
}
