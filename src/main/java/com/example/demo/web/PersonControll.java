package com.example.demo.web;

import com.example.demo.service.PersonService;
import com.example.demo.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/8.
 */
@RestController
public class PersonControll {

    @Autowired
    private PersonService personService;

    @RequestMapping("/rollback")
    public Person rollback(Person person){
        Person p = personService.savePersonWithRollBack(person);
        return p;
    }

    @RequestMapping("/noRollback")
    public Person noRollback(Person person){
        Person p = personService.savePersonWithoutRollBack(person);
        return p;
    }
}
