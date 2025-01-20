package com.perspectrix.market.services;

import com.perspectrix.market.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.perspectrix.market.domain.Person;
import org.springframework.stereotype.Service;

@Service
public class UploadService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PersonRepository personRepository;

    public Person saveOrUpdatePerson(Person person) {
        if (personRepository.existsById(person.getId())) {
            Person existingPerson = personRepository.findById(person.getId()).get();
            if (person.getAddress() != null) {
                existingPerson.setAddress(person.getAddress());
            }
            if (person.getCity() != null) {
                existingPerson.setCity(person.getCity());
            }
            if (person.getState() != null) {
                existingPerson.setState(person.getState());
            }
            if (person.getFName() != null) {
                existingPerson.setFName(person.getFName());
            }
            if (person.getLName() != null) {
                existingPerson.setLName(person.getLName());
            }
            if (person.getPhoneNum() != null) {
                existingPerson.setPhoneNum(person.getPhoneNum());
            }
            if (person.getZip() != null) {
                existingPerson.setZip(person.getZip());
            }
            if (person.getCounty() != null) {
                existingPerson.setCounty(person.getCounty());
            }
            if (person.getMetroArea() != null) {
                existingPerson.setMetroArea(person.getMetroArea());
            }
            if (person.getLat() != null) {
                existingPerson.setLat(person.getLat());
            }
            if (person.getLon() != null) {
                existingPerson.setLon(person.getLon());
            }
            if (person.getAgeRange() != null) {
                existingPerson.setAgeRange(person.getAgeRange());
            }
            if (person.getGender() != null) {
                existingPerson.setGender(person.getGender());
            }
            if (person.getOwnRent() != null) {
                existingPerson.setOwnRent(person.getOwnRent());
            }
            if (person.getHouseholdIncome() != null) {
                existingPerson.setHouseholdIncome(person.getHouseholdIncome());
            }
            if (person.getHomeValue() != null) {
                existingPerson.setHomeValue(person.getHomeValue());
            }
            if (person.getWealth() != null) {
                existingPerson.setWealth(person.getWealth());
            }
            if (person.getLocation() != null) {
                existingPerson.setLocation(person.getLocation());
            }
            return personRepository.save(existingPerson);
        } else {
            // If no ID, save the new person
            return personRepository.save(person);
        }
    }
}
