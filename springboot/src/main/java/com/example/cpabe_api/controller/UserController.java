package com.example.cpabe_api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cpabe_api.entity.User;
import com.example.cpabe_api.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin//允许跨域
public class UserController {

    @Autowired//注入userMapper
    private UserMapper userMapper;

    @GetMapping(value = "/user")
    public List query(){
        List<User> list = userMapper.selectList(null);
//        System.out.println(list);
        return list;
    }

    @GetMapping(value = "/user/findAll")
    public List find(){
        return userMapper.selectAllUserAndOrders();
    }

    //条件查询
    @GetMapping(value = "/user/find")
    public List findByCond(){
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username","lucy");
        return userMapper.selectList(queryWrapper);
    }

    //分页查询
    @GetMapping("/user/findByPage")
    public IPage findByPage(){
        //设置起始值和每页的条数
        Page<User> page = new Page<>(0,2);
        IPage iPage = userMapper.selectPage(page,null);
        return iPage;
    }

    @PostMapping("user")
    public String save(User user){

        int i = userMapper.insert(user);
        System.out.println(user);
        if(i>0){
            return "插入成功";
        }else {
            return "插入失败";
        }
    }
}
