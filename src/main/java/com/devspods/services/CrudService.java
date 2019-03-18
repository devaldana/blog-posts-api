package com.devspods.services;

import java.util.List;

public interface CrudService<E, ID> {

    E save(E entity);
    E findById(ID id);
    void deleteById(ID id);
    List<E> findAll();
}