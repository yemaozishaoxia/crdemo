package com.example.chatroom.service;

import com.example.chatroom.entity.User;

public interface UserService {
    public void addUser(User user);
    public User findUserByUsername(String username);
    public User findUserByEmail(User user);
    public User findUserByUser(User user);
}
