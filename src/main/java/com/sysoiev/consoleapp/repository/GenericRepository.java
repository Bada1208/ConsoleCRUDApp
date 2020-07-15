package com.sysoiev.consoleapp.repository;

import java.io.IOException;
import java.util.List;

public interface GenericRepository<T, ID> {

    T getById(ID id);

    void deleteById(ID id) ;

    T update(T item) ;

    T save(T item);

    List<String> getAll();

}
