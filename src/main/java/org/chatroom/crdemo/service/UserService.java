package org.chatroom.crdemo.service;

import org.chatroom.crdemo.entity.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public User findUserByUsername(String username);
    public User findUserByEmail(User user);
    public User findUserByUser(User user);
}
