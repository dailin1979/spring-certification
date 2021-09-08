package com.ld.util;

import com.ld.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id = rs.getString("ID");
        String username = rs.getString("USERNAME");
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }
}
