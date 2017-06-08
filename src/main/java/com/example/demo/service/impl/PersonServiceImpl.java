package com.example.demo.service.impl;

import com.example.demo.dao.PersonRepository;
import com.example.demo.service.PersonService;
import com.example.demo.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/6/8.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional(rollbackOn = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if(person.getName().equals("wang")){
            throw new IllegalArgumentException("wang have ,rollback");
        }
        return p;
    }

    @Transactional(dontRollbackOn = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        if(person.getName().equals("wang")){
            throw new IllegalArgumentException("wang have ,IllegalArgumentException no rollback");
        }
        return p;
    }
}
