package com.arafa.demo.dao;

import com.arafa.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakdedao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPersons() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
       Optional<Person> personMaybe = selectPersonById(id);
       if(personMaybe.isEmpty()){
           return 0;
       }
       else {
            DB.remove(personMaybe.get());
            return 1;
       }
    }

    @Override
    public int updatePersonById(UUID id, Person personUpdate) {
        return selectPersonById(id)
                .map(p ->{
                    int indexOfPersonToUpdate = DB.indexOf(p);
                    if(indexOfPersonToUpdate >= 0){
                       DB.set(indexOfPersonToUpdate, new Person(id, personUpdate.getName()));
                       return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
