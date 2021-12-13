package com.xxxmkxxx.storage;

import java.util.List;

public interface IDataAccessLayer <T> {
    T read(int id, Class model);
    List<T> read(Class model);
    List<T> read(Class model,String query);
    void delete(int id, Class model);
    void update(int id, Class model);
    void create(Class model);
}
