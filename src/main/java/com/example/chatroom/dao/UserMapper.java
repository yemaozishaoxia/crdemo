package com.example.chatroom.dao;

import java.util.List;

import com.example.chatroom.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

  int insert(User user);

  User selectByUsername(String username);

  User findUserByEmail(String email);

  User findUserByUser(User user);

  int deleteUserById(Long userid);
}
