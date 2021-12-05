package com.xxxmkxxx.storage;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataManager implements IDataLayer {
    private IDataLayer data;

    @Override
    public Object getRecordById(int id, String tableName) {
        return null;
    }

    @Override
    public List<Object> getAllRecords(String tableName) {
        return null;
    }

    @Override
    public void removeRecord(int id, String tableName) {

    }

    @Override
    public void replaceRecord(int id, Object object, String tableName) {

    }

    @Override
    public void saveRecord(Object object) {

    }

    public DataManager() {
        this.data = new DataBaseService("localhost", "PolarGame", "admin", "admin");
    }
}
