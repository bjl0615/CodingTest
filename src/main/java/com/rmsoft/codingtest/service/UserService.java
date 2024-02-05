package com.rmsoft.codingtest.service;

import com.rmsoft.codingtest.Controller.UserController;
import com.rmsoft.codingtest.mapper.UserMapper;
import com.rmsoft.codingtest.model.RoleType;
import com.rmsoft.codingtest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void join(User user) {
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        user.setPassword(encPassword);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setCreateDate(timestamp);
        if (user.getUsername().equals("admin")) {
            System.out.println(user.getUsername());
            user.setRole(RoleType.ADMIN);
        } else {
            user.setRole(RoleType.USER);
        }
        userMapper.save(user);
    }

    @Transactional
    public void update(User user) {
        User persistence = userMapper.findByUsername(user.getUsername());
        if (persistence == null) {
            throw new IllegalArgumentException("회원 찾기 실패");
        }
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        persistence.setPassword(encPassword);
        persistence.setEmail(user.getEmail());

        userMapper.update(persistence);
    }
}
