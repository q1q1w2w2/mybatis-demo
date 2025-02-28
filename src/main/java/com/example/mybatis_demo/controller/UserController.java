package com.example.mybatis_demo.controller;

import com.example.mybatis_demo.domain.User;
import com.example.mybatis_demo.dto.SignupDto;
import com.example.mybatis_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.HttpStatus.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/user")
    public ResponseEntity signup(@RequestBody SignupDto signupDto) {
        User user = userService.signup(signupDto);
        return ResponseEntity.status(CREATED).body(user);
    }

    @GetMapping("/api/user")
    public ResponseEntity getUserByUsername(@RequestParam("username") String username) {
        User user = userService.findUserByUsername(username);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/api/user/test")
    public ResponseEntity test(@RequestParam("username") String username) {
        userService.test(username);
        return ResponseEntity.ok().body("!");
    }
}
