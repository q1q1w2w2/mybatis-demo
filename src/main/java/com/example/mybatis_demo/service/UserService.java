package com.example.mybatis_demo.service;

import com.example.mybatis_demo.domain.User;
import com.example.mybatis_demo.dto.SignupDto;
import com.example.mybatis_demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    @Transactional
    public User signup(SignupDto signupDto) {
        User user = User.builder()
                .username(signupDto.getUsername())
                .email(signupDto.getEmail())
                .password(signupDto.getPassword())
                .build();
        userMapper.save(user);
        return user;
    }

    public User findUserByUsername(String username) {
        Optional<User> optionalUser = Optional.ofNullable(userMapper.findByUsername(username));
        return optionalUser.orElseThrow(() -> new RuntimeException("그런사람없음"));
    }

    public void test(String username) {
        userMapper.findByUsername(username);
        userMapper.findByUsername(username);
    }

}
