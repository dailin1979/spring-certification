package com.ld.repos;

import com.ld.entities.User;

import java.util.Optional;
import java.util.Set;

public interface UserRepo extends AbstractRepo<User> {
    Set<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);


}
