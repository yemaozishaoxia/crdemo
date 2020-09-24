package com.example.chatroom.service.impl;

import com.example.chatroom.enums.ApiMsgEnum;
import com.example.chatroom.exception.Api403Exception;
import com.example.chatroom.exception.ApiErrorException;
import com.example.chatroom.service.UserService;
import com.example.chatroom.dao.UserMapper;
import com.example.chatroom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired private UserMapper userMapper;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public int addUser(User user) {
    int rows=0;
    try {
      rows=this.userMapper.insert(user);
    } catch (Exception e) {
      throw new Api403Exception(ApiMsgEnum.DATABASE_EXCEPTION);
    }
    return rows;
  }

  @Override
  @Transactional
  public User findUserByUsername(String username) {
    User user = this.userMapper.selectByUsername(username);
    return user;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public User findUserByEmail(String email) {
    User user = this.userMapper.findUserByEmail(email);
    return user;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public User findUserByUser(User user) {
    User user1 = this.userMapper.findUserByUser(user);
    return user1;
  }
}
