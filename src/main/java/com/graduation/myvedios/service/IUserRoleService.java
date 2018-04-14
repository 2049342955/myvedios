package com.graduation.myvedios.service;

import com.github.pagehelper.PageInfo;
import com.graduation.myvedios.entity.UserRole;

import java.util.List;

public interface IUserRoleService {
    UserRole get(String id);
    UserRole selectOne(UserRole userRole);
    List<UserRole> list(UserRole userRole);
    PageInfo<UserRole> query(UserRole userRole);
    UserRole save(UserRole userRole);
    int delete(UserRole userRole);
}
