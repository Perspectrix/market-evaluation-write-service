package com.perspectrix.market.repositories;

import com.perspectrix.market.domain.Person;

import java.util.List;

public interface CustomPersonRepository {
        List<String> findDistinctCities();
        List<Person> findByCity(String city);
}
