package com.ld.dao;

import com.ld.entity.Person;
import com.ld.util.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonDaoImpl implements PersonDao {

    RowMapper<Person> rowMapper = new PersonRowMapper();


    JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Person> findById(int id) {
        String sql = "select ID, NAME, ADDRESS from PERSON where ID= ?";
        return Optional.of(jdbcTemplate.queryForObject(sql, rowMapper, id));
    }

}
