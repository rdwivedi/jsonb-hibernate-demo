package com.rd.demo.repositories;

import com.rd.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
