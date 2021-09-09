package com.ld.util;

import com.ld.entity.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("ID");
        String name = rs.getString("NAME");
        String address = rs.getString("ADDRESS");

        Person person = new Person();

        person.setId(id);
        person.setName(name);
        person.setAddress(address);
        return person;
    }
}
