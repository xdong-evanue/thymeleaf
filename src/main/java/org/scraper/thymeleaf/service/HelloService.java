package org.scraper.thymeleaf.service;

import org.scraper.thymeleaf.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private final UserMapper userMapper;

    public HelloService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String getUserName(int id) {
        return userMapper.findById(id).getName();
    }
}
