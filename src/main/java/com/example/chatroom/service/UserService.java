package com.example.chatroom.service;

import com.example.chatroom.entity.User;

public interface UserService {
     int addUser(User user);
     User findUserByUsername(String username);
     User findUserByEmail(String email);
     User findUserByUser(User user);
}
