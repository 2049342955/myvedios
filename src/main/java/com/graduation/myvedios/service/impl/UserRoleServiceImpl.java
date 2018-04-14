package com.graduation.myvedios.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.graduation.myvedios.entity.UserRole;
import com.graduation.myvedios.mapper.UserRoleMapper;
import com.graduation.myvedios.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements IUserRoleService{
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserRole get(String id) {
        UserRole userRole = new UserRole();
        userRole.setId(id);
        return userRoleMapper.selectByPrimaryKey(userRole);
    }

    @Override
    public UserRole selectOne(UserRole userRole) {
        return userRoleMapper.selectOne(userRole);
    }

    @Override
    public List<UserRole> list(UserRole userRole) {
        return userRoleMapper.select(userRole);
    }

    @Override
    public PageInfo<UserRole> query(UserRole userRole) {
        return null;
    }

    @Override
    public UserRole save(UserRole userRole) {
        if(StringUtil.isEmpty(userRole.getId())){
            userRoleMapper.insert(userRole);
        }else{
            userRoleMapper.updateByPrimaryKeySelective(userRole);
        }
        return userRole;
    }

    @Override
    public int delete(UserRole userRole) {
        return userRoleMapper.delete(userRole);
    }
}
