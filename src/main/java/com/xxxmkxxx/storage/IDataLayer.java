package com.xxxmkxxx.storage;

import java.util.List;

public interface IDataLayer {
    Object getRecordById(int id, String tableName);
    List<Object> getAllRecords(String tableName);
    void removeRecord(int id, String tableName);
    void replaceRecord(int id, Object object, String tableName);
    void saveRecord(Object object);
}
