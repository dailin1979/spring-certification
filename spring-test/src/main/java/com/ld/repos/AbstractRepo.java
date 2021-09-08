package com.ld.repos;

import com.ld.entities.AbstractEntity;

import java.util.Optional;

public interface AbstractRepo <T extends AbstractEntity> {
    void save(T entity);

    void delete(T entity);

    T update(T entity);

    int deleteById(Long entityId);

    Optional<T> findById(Long entityId);
}
