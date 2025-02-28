package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.domain.User;
import org.apache.ibatis.annotations.*;

//@CacheNamespace(size = 512)
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user (username, email, password) VALUES (#{username}, #{email}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(User user);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(@Param("username") String username);
}
