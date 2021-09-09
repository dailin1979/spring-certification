package com.ld.service;

import com.ld.dao.PersonDao;
import com.ld.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person findPersonById(int id){
        return personDao.findById(id).get();
    }
}
