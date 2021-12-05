package com.xxxmkxxx.storage;

import org.springframework.stereotype.Component;

import java.util.List;

public class DataBaseService implements IDataLayer {
    private String host;
    private String dbName;
    private String dbLogin;
    private String dbPassword;

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

    public DataBaseService(String host, String dbName, String dbLogin, String dbPassword) {
        this.host = host;
        this.dbName = dbName;
        this.dbLogin = dbLogin;
        this.dbPassword = dbPassword;
    }
}
