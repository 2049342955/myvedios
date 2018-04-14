package com.graduation.myvedios.service;

import com.github.pagehelper.PageInfo;
import com.graduation.myvedios.entity.Type;

import java.util.List;

public interface ITypeService {
    Type get(String id);
    Type selectOne(Type type);
    List<Type> list(Type type);
    PageInfo<Type> query(Type type);
    Type save(Type type);
    int delete(Type type);
}
