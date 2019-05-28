package com.hbx.springbootmybatisxml.mapper;

import com.hbx.springbootmybatisxml.model.User;

import java.util.List;

public interface Mapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);

}
