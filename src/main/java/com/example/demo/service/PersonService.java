package com.example.demo.service;

import com.example.demo.vo.Person;

/**
 * Created by Administrator on 2017/6/8.
 */
public interface PersonService {
    Person savePersonWithRollBack(Person person);
    Person savePersonWithoutRollBack(Person person);
}
