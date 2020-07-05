package com.sysoiev.console_app.repository;

import java.io.IOException;
import java.util.List;

public interface GenericRepository<T, ID> {

    T getByIndexInCollection(ID id) throws IOException;

    void delete(T item) throws IOException;

    void update(T item);

    List<T> getList();

}
