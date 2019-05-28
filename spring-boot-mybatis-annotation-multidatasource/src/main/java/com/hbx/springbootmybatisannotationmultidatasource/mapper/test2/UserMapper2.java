package com.hbx.springbootmybatisannotationmultidatasource.mapper.test2;

import com.hbx.springbootmybatisannotationmultidatasource.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper2 {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    User getOne(Long id);

    @Insert("INSERT INTO users(user_name,pass_word) VALUES(#{userName}, #{passWord})")
    void insert(User user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
}
