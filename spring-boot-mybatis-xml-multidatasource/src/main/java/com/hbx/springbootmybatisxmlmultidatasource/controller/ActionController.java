package com.hbx.springbootmybatisxmlmultidatasource.controller;

import com.hbx.springbootmybatisxmlmultidatasource.mapper.test1.UserMapper1;
import com.hbx.springbootmybatisxmlmultidatasource.mapper.test2.UserMapper2;
import com.hbx.springbootmybatisxmlmultidatasource.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class ActionController {

    @Autowired
    private UserMapper1 user1Mapper;

    @Autowired
    private UserMapper2 user2Mapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users=user1Mapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user=user2Mapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String save(User user) {
        System.out.print("\n");
        System.out.print(user.toString());
        System.out.print("\n");

        try {
            user1Mapper.insert(user);
            user2Mapper.insert(user);
        }catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }

        return "success";
    }

    @RequestMapping(value="update")
    public void update(User user) {
        user2Mapper.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }

}
