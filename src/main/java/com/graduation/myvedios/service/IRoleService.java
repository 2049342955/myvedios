package com.graduation.myvedios.service;

import com.github.pagehelper.PageInfo;
import com.graduation.myvedios.entity.Role;
import com.graduation.myvedios.entity.User;

import java.util.List;

public interface IRoleService {
    Role get(String id);
    Role selectOne(Role role);
    List<Role> list(Role role);
    PageInfo<Role> query(Role role);
    Role save(Role role);
    int delete(Role role);
    List<Role> getByUser(User user);
}
