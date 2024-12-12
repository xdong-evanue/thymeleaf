package org.scraper.thymeleaf.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.scraper.thymeleaf.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(int id);

    @Select("SELECT * FROM users")
    List<User> findAll();
}
