package org.example.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.example.springboot.entity.UserAccount;

public interface UserMapper {

//@Select("select * from 'users' where username= #{username}")
//UserAccount selectByUsername(String username);
//@Insert("insert into'users'(username,password,identity)values(#{username},#{password},#{identity})")
//UserAccount insert(UserAccount user);
    @Select("select * from users where username = #{username}")
    UserAccount selectByUsername(String username);

    @Insert("insert into users (username, password, identity) values (#{username}, #{password}, #{identity})")
    void insert(UserAccount user);
}
