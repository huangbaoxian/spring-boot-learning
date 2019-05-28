package com.hbx.springbootmybatisannotation.controller;

import com.hbx.springbootmybatisannotation.mapper.UserMapper;
import com.hbx.springbootmybatisannotation.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class AnnotationController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    @ResponseBody
    public List<UserModel> getUsers() {
        List<UserModel> users=userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public UserModel getUser(Long id) {
        UserModel user=userMapper.getOne(id);
        return user;
    }

    @ResponseBody
    @RequestMapping("/add")
    public String save(UserModel user) {
        try {
            System.out.print(user.toString());
            userMapper.insert(user);
        }catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @RequestMapping(value="update")
    @ResponseBody
    public String update(UserModel user) {
       try {
           userMapper.update(user);
       }catch (Exception e) {
           e.printStackTrace();
           return "failed";
       }
       return "success";
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }

}