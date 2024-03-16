package com.turkcell.rentacar.business.abstracts;

import java.io.IOException;
import java.util.List;

public interface IService<T>{
    T add (T entity);
    T update(int id,T entity) throws IOException;
    List<T> getAll();
    T getById(int id);
    void delete(T entity);
}
