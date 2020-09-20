package com.example.chatroom.service.impl;

import com.example.chatroom.service.UserService;
import com.example.chatroom.dao.UserMapper;
import com.example.chatroom.entity.User;
import com.example.chatroom.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userMapper;

  @Override
  @Transactional
  public void addUser(User user) {
    this.userMapper.insert(user);
  }

  @Override
  @Transactional
  public User findUserByUsername(String username) {
    User user=this.userMapper.selectByUsername(username);
    return user;
  }

  @Override
  @Transactional
  public User findUserByEmail(User user) {
    UserExample example=new UserExample();
    List<User> users=null;
    UserExample.Criteria criteria = example.createCriteria();
    criteria.andEmailEqualTo(user.getEmail());
    users=this.userMapper.selectByExample(example);
    return users.get(0);
  }

  @Override
  public User findUserByUser(User user) {
    UserExample example=new UserExample();
    List<User> users=null;
    UserExample.Criteria criteria = example.createCriteria();
    criteria.andUsernameEqualTo(user.getUsername());
    criteria.andPasswordEqualTo(user.getPassword());
    users=this.userMapper.selectByExample(example);
    return users.get(0);
  }
}
