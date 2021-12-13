package com.xxxmkxxx.storage;

import com.xxxmkxxx.services.DataBaseService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataManager <T> implements IDataAccessLayer {
    private IDataAccessLayer <T> data;

    @Override
    public T read(int id, Class model) {
        return (T) data.read(id, model);
    }

    @Override
    public List<T> read(Class model) {
        return data.read(model);
    }

    @Override
    public List<T> read(Class model, String query) {
        return data.read(model, query);
    }

    @Override
    public void delete(int id, Class model) {

    }

    @Override
    public void update(int id, Class model) {

    }

    @Override
    public void create(Class model) {

    }

    public DataManager(DataBaseService data) {
        this.data = data;
    }
}
