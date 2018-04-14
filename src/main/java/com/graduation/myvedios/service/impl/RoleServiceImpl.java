package com.graduation.myvedios.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.graduation.myvedios.entity.Role;
import com.graduation.myvedios.entity.User;
import com.graduation.myvedios.mapper.RoleMapper;
import com.graduation.myvedios.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService{
    @Autowired
    private RoleMapper mapper;

    @Override
    public Role get(String id) {
        Role role = new Role();
        role.setId(id);
        return mapper.selectByPrimaryKey(role);
    }

    @Override
    public Role selectOne(Role role) {
        return mapper.selectOne(role);
    }

    @Override
    public List<Role> list(Role role) {
        return mapper.select(role);
    }

    @Override
    public PageInfo<Role> query(Role role) {
        return null;
    }

    @Override
    public Role save(Role role) {
        if(StringUtil.isEmpty(role.getId())){
            mapper.insert(role);
        }else{
            mapper.updateByPrimaryKeySelective(role);
        }
        return role;
    }

    @Override
    public int delete(Role role) {
        return mapper.delete(role);
    }

    @Override
    public List<Role> getByUser(User user) {
        return mapper.getByUser(user);
    }
}
