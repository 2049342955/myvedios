package com.graduation.myvedios.web;

import com.github.pagehelper.StringUtil;
import com.graduation.myvedios.entity.User;
import com.graduation.myvedios.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/login")
    public User login(User user){
        return iUserService.selectOne(user);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        if(StringUtil.isEmpty(user.getStatus())){
            user.setStatus("Y");
        }
        return iUserService.save(user);
    }

}
