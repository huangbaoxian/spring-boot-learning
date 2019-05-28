package com.hbx.springbootmybatisannotation.mapper;

import com.hbx.springbootmybatisannotation.model.UserModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "nickName", column = "nick_name")
    })
    public List<UserModel> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "nickName", column = "nick_name")
    })
    public UserModel getOne(Long id);

    @Insert("INSERT INTO users(user_name,pass_word) VALUES(#{userName}, #{passWord})")
    public void insert(UserModel user);

    @Update("UPDATE users SET user_name=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    public void update(UserModel user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    public void delete(Long id);

}


/*
*
*
* CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `pass_word` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `user_sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
*
*
*
* */