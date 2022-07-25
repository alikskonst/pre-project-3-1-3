package edu.kata.task313.service;

import java.util.List;

public interface CommonService<E> {

    E findOne(Long id);

    List<E> findAll();

    E save(E entity);

    void remove(Long id);
}