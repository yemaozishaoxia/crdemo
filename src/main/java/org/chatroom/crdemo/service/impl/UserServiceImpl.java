package org.chatroom.crdemo.service.impl;

import org.chatroom.crdemo.dao.UserMapper;
import org.chatroom.crdemo.entity.User;
import org.chatroom.crdemo.entity.UserExample;
import org.chatroom.crdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
