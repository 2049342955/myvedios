package com.graduation.myvedios.mapper;

import com.graduation.myvedios.entity.Role;
import com.graduation.myvedios.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface RoleMapper extends Mapper<Role> {
    List<Role> getByUser(@Param("user") User user);
}