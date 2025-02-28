package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@CacheNamespace(size = 512)
@Mapper
public interface UserMapper {

    void save(User user);

    User findByUsername(@Param("username") String username);

    List<User> findAll();
}
