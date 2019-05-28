package com.hbx.springbootmybatisxmlmultidatasource.mapper.test1;

import com.hbx.springbootmybatisxmlmultidatasource.model.User;

import java.util.List;

public interface UserMapper1 {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);


}
