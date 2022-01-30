package com.xxxmkxxx.dao;

import java.util.List;

public interface DAO <T> {
    boolean create(T model);
    List<T> read();
    T read(int index);
    boolean update(T model);
    boolean delete(T model);
}
