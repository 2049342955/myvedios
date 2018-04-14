package com.graduation.myvedios.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.graduation.myvedios.entity.UserRole;
import com.graduation.myvedios.entity.User;
import com.graduation.myvedios.mapper.UserMapper;
import com.graduation.myvedios.mapper.UserRoleMapper;
import com.graduation.myvedios.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

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
    @Transactional
    public User save(User user) {
        if(StringUtil.isEmpty(user.getId())){
            mapper.insert(user);
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId("35cbfe863fa011e8a66554a050ae6420");
            userRole.setStatus("Y");
            userRoleMapper.insert(userRole);
        }else{
            mapper.updateByPrimaryKeySelective(user);
        }
        return user;
    }

    @Override
    @Transactional
    public int delete(User user) {
        Integer result = mapper.delete(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRoleMapper.delete(userRole);
        return result;
    }

    @Override
    @Transactional
    public User addAdmin(User user) {
        mapper.insert(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId("35cbfe863fa011e8a66554a050ae6420");
        userRole.setStatus("Y");
        userRoleMapper.insert(userRole);
        userRole.setRoleId("0c8f803a3fa011e8a66554a050ae6420");
        userRole.setUserId(user.getId());
        userRole.setStatus("Y");
        userRoleMapper.insert(userRole);
        return user;
    }
}
