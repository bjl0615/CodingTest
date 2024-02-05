package com.rmsoft.codingtest.mapper;

import com.rmsoft.codingtest.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);

    @Insert("INSERT INTO user (username, email, password, role, createDate) VALUES (#{username}, #{email} ,#{password} , #{role} , #{createDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(User user);

    @Update("UPDATE user SET password = #{password}, email = #{email} WHERE username = #{username}")
    int update(User user);
}