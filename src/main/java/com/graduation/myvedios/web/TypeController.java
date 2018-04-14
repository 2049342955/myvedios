package com.graduation.myvedios.web;

import com.graduation.myvedios.entity.Type;
import com.graduation.myvedios.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private ITypeService iTypeService;

    @GetMapping("/list")
    public List<Type> list(Type type){
        return iTypeService.list(type);
    }

    @PostMapping("/save")
    public Type save(Type type){
        return iTypeService.save(type);
    }
}
