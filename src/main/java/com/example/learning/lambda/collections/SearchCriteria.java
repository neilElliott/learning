package com.example.learning.lambda.collections;

import com.example.learning.lambda.domain.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

@Slf4j
public class SearchCriteria {

    private final Map<String, Predicate<Person>> searchMap = new HashMap<>();

    private SearchCriteria() {
        super();
        initSearchMap();
    }

    private void initSearchMap() {
        // Add Predicate directly to map.
        searchMap.put("activePlayers", person -> person.getAge() >= 20 && person.getAge() <= 35);
        searchMap.put("youthPlayers", person -> person.getAge() <= 19);
        searchMap.put("allPlayers", person -> person.getAge() >= 18);
    }

    public Predicate<Person> getCriteria(String predicateName) {
        Predicate<Person> target = searchMap.get(predicateName);

        if (target == null) {
            log.error("Search Criteria {} could not be found...", predicateName);
            System.exit(1);
        }

        return target;
    }

    public static SearchCriteria getInstance() {
        return new SearchCriteria();
    }
}
