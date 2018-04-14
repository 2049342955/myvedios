package com.graduation.myvedios.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.graduation.myvedios.entity.Type;
import com.graduation.myvedios.mapper.TypeMapper;
import com.graduation.myvedios.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements ITypeService{
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Type get(String id) {
        Type type = new Type();
        type.setId(id);
        return typeMapper.selectByPrimaryKey(type);
    }

    @Override
    public Type selectOne(Type type) {
        return null;
    }

    @Override
    public List<Type> list(Type type) {
        return typeMapper.select(type);
    }

    @Override
    public PageInfo<Type> query(Type type) {
        return null;
    }

    @Override
    public Type save(Type type) {
        if(StringUtil.isEmpty(type.getId())){
            typeMapper.insert(type);
        }else{
            typeMapper.updateByPrimaryKeySelective(type);
        }
        return type;
    }

    @Override
    public int delete(Type type) {
        return typeMapper.delete(type);
    }
}
