package com.arafa.demo.dao;

import com.arafa.demo.model.Person;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

int insertPerson(UUID id, Person person);

default int insertPerson(Person person){
    UUID id = UUID.randomUUID();
    return insertPerson(id,person);
}

List<Person> getAllPersons();

Optional<Person> selectPersonById(UUID id);


int deletePersonById(UUID id);

int updatePersonById(UUID id, Person person);



}
