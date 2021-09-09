package com.ld.repos;

import com.ld.entities.User;
import com.ld.util.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public class JdbcUserRepoImpl extends JdbcAbstractRepo<User> implements UserRepo {
  protected RowMapper<User> rowMapper = new UserRowMapper();

  public JdbcUserRepoImpl(JdbcTemplate jdbcTemplate) {
    super(jdbcTemplate);
  }

  @Override
  public Set<User> findAll() {
    return null;
  }

  @Override
  public Optional<User> findById(Long id) {
    String sql = "select ID, USERNAME, FIRSTNAME, LASTNAME from USER where ID= ?";
    return Optional.of(jdbcTemplate.queryForObject(sql, rowMapper, id));
  }

  @Override
  public Optional<User> findByUsername(String username) {
    return Optional.empty();
  }
}
