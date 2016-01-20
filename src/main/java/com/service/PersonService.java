package com.service;

import com.dao.PersonRepository;
import com.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void savePerson(Person person){
        personRepository.save(person);
    }

    public Person getPerson(long id){
       return personRepository.getPerson(id);
    }
}
