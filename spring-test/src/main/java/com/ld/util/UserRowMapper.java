package com.ld.util;

import com.ld.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("ID");
        String username = rs.getString("USERNAME");
        String firstname = rs.getString("FIRSTNAME");
        String lastname = rs.getString("LASTNAME");

        User user = new User();
        user.setId(id);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setUsername(username);
        return user;
    }
}
