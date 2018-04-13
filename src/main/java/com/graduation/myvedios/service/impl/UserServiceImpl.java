package com.graduation.myvedios.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.graduation.myvedios.entity.User;
import com.graduation.myvedios.mapper.UserMapper;
import com.graduation.myvedios.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper mapper;

    @Override
    public User get(String id) {
        User user = new User();
        user.setId(id);
        return mapper.selectByPrimaryKey(user);
    }

    @Override
    public User selectOne(User user) {
        return mapper.selectOne(user);
    }

    @Override
    public List<User> list(User user) {
        return mapper.select(user);
    }

    @Override
    public PageInfo<User> query(User user) {
        return null;
    }

    @Override
    public User save(User user) {
        if(StringUtil.isEmpty(user.getId())){
            mapper.insert(user);
        }else{
            mapper.updateByPrimaryKeySelective(user);
        }
        return user;
    }

    @Override
    public int delete(User user) {
        return mapper.delete(user);
    }
}
