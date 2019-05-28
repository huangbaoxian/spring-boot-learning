package com.hbx.springbootmybatisxmlmultidatasource.mapper.test2;

import com.hbx.springbootmybatisxmlmultidatasource.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper2 {
    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);

}
