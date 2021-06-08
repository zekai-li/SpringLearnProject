package com.learn.service;

import com.learn.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;
    public void saveEntity(T t){
        baseDao.saveEntity(t);
    }
}
