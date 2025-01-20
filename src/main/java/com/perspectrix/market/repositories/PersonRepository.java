package com.perspectrix.market.repositories;

import com.perspectrix.market.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>, CustomPersonRepository {
}
