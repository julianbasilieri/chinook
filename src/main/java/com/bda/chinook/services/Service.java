package com.bda.chinook.services;

import java.util.List;

public interface Service<T, W> {
    void add(T entity);
    T delete(W id);
    void update(T entity);
    List<T> getAll();
    T getById(W id);
}
