package com.ld.dao;

import com.ld.entity.Person;

import java.util.Optional;

public interface PersonDao {
    public Optional<Person> findById(int id);
}
