package com.learn.dao;

public interface BaseDao<T> {
    public void saveEntity(T t);
}
