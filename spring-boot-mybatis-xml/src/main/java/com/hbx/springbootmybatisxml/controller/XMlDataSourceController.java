package com.hbx.springbootmybatisxml.controller;

import com.hbx.springbootmybatisxml.mapper.Mapper;
import com.hbx.springbootmybatisxml.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class XMlDataSourceController {

    @Autowired
    private Mapper userMapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users=userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user=userMapper.getOne(id);
        return user;
    }

    @ResponseBody
    @RequestMapping("/add")
    public String save(User user) {
        System.out.print(user.toString());
        try {
            userMapper.insert(user);
        }catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }


    @RequestMapping(value="update")
    public void update(User user) {
        userMapper.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }

}
