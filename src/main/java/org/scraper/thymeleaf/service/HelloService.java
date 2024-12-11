package org.scraper.thymeleaf.service;

import org.scraper.thymeleaf.entity.User;
import org.scraper.thymeleaf.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    private final UserMapper userMapper;

    public HelloService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String getUserName(int id) {
        return userMapper.findById(id).getName();
    }

    public List<User> getAllUsers() {
        return userMapper.findAll();
    }
}
