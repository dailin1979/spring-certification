package com.ld.controller;

import com.ld.entity.Person;
import com.ld.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    static Logger logger = LoggerFactory.getLogger(PersonController.class);

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/person/{id}")
    @ResponseBody
    public Person getPerson(@PathVariable int id) {
//        long start = System.currentTimeMillis();
        Person person = personService.findPersonById(id);
//        long end = System.currentTimeMillis();
//        logger.info("es dauert {} ms", (end-start));
        return person;
    }

}
