package com.arafa.demo.service;

import com.arafa.demo.dao.PersonDao;
import com.arafa.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
//    public PersonService(@Qualifier("fakedao") PersonDao personDao) {
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
    return personDao.insertPerson(person);
}

public List<Person> getALlPersons(){
     return personDao.getAllPersons();
}

public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
}

public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
}

public int updatePerson(UUID id, Person updatedPerson){
        return personDao.updatePersonById(id,updatedPerson);
}


}
