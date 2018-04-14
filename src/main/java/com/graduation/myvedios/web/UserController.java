package com.graduation.myvedios.web;

import com.github.pagehelper.StringUtil;
import com.graduation.myvedios.entity.Role;
import com.graduation.myvedios.entity.User;
import com.graduation.myvedios.service.IRoleService;
import com.graduation.myvedios.service.IUserRoleService;
import com.graduation.myvedios.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IUserRoleService iUserRoleService;

    @Autowired
    private IRoleService iRoleService;


    @GetMapping("/login")
    public Map login(User user){
        Map map = new HashMap();
        user = iUserService.selectOne(user);
        map.put("user",user);
        Role role = new Role();
        List<Role> roleList = new ArrayList<>();
        roleList = iRoleService.getByUser(user);
        map.put("role",roleList);
        return map;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        if(StringUtil.isEmpty(user.getStatus())){
            user.setStatus("Y");
        }
        return iUserService.save(user);
    }

    @PostMapping("/save")
    public User save(@RequestBody User user){
        return iUserService.save(user);
    }

    @PostMapping("/addAdmin")
    public User addAdmin(@RequestBody User user){
        user.setStatus("Y");
        return iUserService.addAdmin(user);
    }

    @GetMapping("/get")
    public User get(String id){
        return iUserService.get(id);
    }

    @GetMapping("/selectOne")
    public User selectOne(User user){
        return iUserService.selectOne(user);
    }

    @GetMapping("/list")
    public List<User> list(User user){
        return iUserService.list(user);
    }

    @GetMapping("/delete")
    public boolean delete(User user){
        return iUserService.delete(user)>0;
    }

}
