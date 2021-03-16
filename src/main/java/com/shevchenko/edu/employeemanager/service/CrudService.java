package com.shevchenko.edu.employeemanager.service;

import java.util.List;

public interface CrudService<T, ID> {

    T add(T entity);

    List<T> findAll();

    T update(T entity);

    void delete(ID id);

    T findById(ID id);
}
