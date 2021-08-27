package ioc.bean.lifecycle.controller;

import ioc.bean.lifecycle.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//@Resource(name = "personController")
@Component("personController")
public class PersonControllerImpl implements PersonController{

    private static final Logger logger = LoggerFactory.getLogger(PersonControllerImpl.class);

    private PersonService personService;

    @Autowired
    public PersonControllerImpl(PersonService personService) {
        this.personService = personService;
    }
}
